import json
import os

def extract_lap_positions(input_file, output_file):
    # Check if input file exists
    if not os.path.exists(input_file):
        print(f"Error: The file '{input_file}' does not exist.")
        return

    try:
        # Read the JSON file with UTF-8 encoding
        with open(input_file, 'r', encoding='utf-8') as file:
            data = json.load(file)

        print("DEBUG: Loaded JSON data successfully.")
        print(f"DEBUG: Top-level keys in input JSON: {list(data.keys())}")

        # Initialize filtered data
        filtered_data = {"teams": []}

        # Process lapData if it exists
        if 'lapData' in data:
            print(f"DEBUG: Found 'lapData' with {len(data['lapData'])} entries.")
            for entry in data['lapData']:
                # Extract team info from the first available lap (e.g., lap_0 or lap_1)
                team_info = {}
                for key in ['lap_0', 'lap_1']:
                    if key in entry:
                        team_info['group_id'] = entry[key].get('group_id')
                        team_info['name'] = entry[key].get('name')
                        break
                if not team_info:
                    print("DEBUG: No team info found in entry, skipping.")
                    continue

                # Collect lap positions as a dictionary {lap_number: lap_position}
                lap_positions = {}
                for key in entry.keys():
                    if key.startswith('lap_'):
                        try:
                            lap_num = int(key.split('_')[1])
                            if lap_num > 0:  # Exclude lap_0
                                pos = entry[key].get('lap_position')
                                if pos is not None:
                                    lap_positions[lap_num] = pos
                                    print(f"DEBUG: Team '{team_info['name']}' lap_{lap_num}: lap_position = {pos}")
                                else:
                                    print(f"DEBUG: Team '{team_info['name']}' lap_{lap_num}: lap_position is None, skipping")
                        except ValueError:
                            print(f"DEBUG: Invalid lap key '{key}', skipping")
                            continue

                if not lap_positions:
                    print(f"DEBUG: No valid lap positions found for team '{team_info['name']}', skipping")
                    continue

                # Create a filled list from lap 1 to max_lap, using forward fill for missing positions
                if lap_positions:
                    min_lap = min(lap_positions.keys())
                    max_lap = max(lap_positions.keys())
                    positions_list = []
                    current_pos = entry.get('lap_0', {}).get('lap_position')  # Start with starting position if available
                    for lap in range(1, max_lap + 1):
                        pos = lap_positions.get(lap)
                        if pos is not None:
                            current_pos = pos
                        positions_list.append(current_pos)

                team_info['positions'] = positions_list
                filtered_data['teams'].append(team_info)
                print(f"DEBUG: Added team '{team_info['name']}' with {len(positions_list)} lap positions (forward filled)")

        else:
            print("DEBUG: No 'lapData' key found in input JSON")

        print(f"DEBUG: Final filtered data contains {len(filtered_data['teams'])} teams")
        if not filtered_data['teams']:
            print("WARNING: No teams with valid lap positions found. Writing empty teams list.")

        # Write the filtered data to a new JSON file
        with open(output_file, 'w', encoding='utf-8') as file:
            json.dump(filtered_data, file, indent=4)
        print(f"Extracted lap positions written to '{output_file}'")

    except json.JSONDecodeError:
        print("Error: The input file is not a valid JSON file.")
    except UnicodeDecodeError as e:
        print(f"Encoding error: {str(e)}. Try using 'utf-8-sig' or 'latin1' encoding.")
    except Exception as e:
        print(f"An error occurred: {str(e)}")

# Example usage
if __name__ == "__main__":
    input_file = r"C:\Users\Marc Mas\Documents\Code\Other\PLM\input3.json"
    output_file = r"C:\Users\Marc Mas\Documents\Code\Other\PLM\output3.json"
    extract_lap_positions(input_file, output_file)