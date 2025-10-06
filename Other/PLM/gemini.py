import json
import csv
import re

def process_lap_data(file_path):
    """
    Reads race data from a JSON file and organizes each team's position for every lap entry.

    Args:
        file_path (str): The path to the input JSON file.

    Returns:
        tuple: A tuple containing:
            - dict: A dictionary with team names as keys. Each value is a list of
                    dictionaries containing 'lap_id' and 'position' for each lap entry.
            - int: The total number of lap entries recorded.
    """
    try:
        with open(file_path, 'r', encoding='utf-8') as f:
            data = json.load(f)
    except FileNotFoundError:
        print(f"Error: The file '{file_path}' was not found.")
        return None, 0
    except json.JSONDecodeError:
        print(f"Error: The file '{file_path}' is not a valid JSON file.")
        return None, 0

    team_lap_positions = {}
    lap_count = 0
    skipped_entries = 0

    if 'lapData' in data and isinstance(data['lapData'], list):
        lap_count = len(data['lapData'])
        print(f"Found {lap_count} lap entries in 'lapData'.")

        # Iterate over each lap entry
        for lap_index, lap_session_data in enumerate(data['lapData']):
            if not isinstance(lap_session_data, dict):
                print(f"Warning: Lap entry {lap_index + 1} is not a dictionary, skipping.")
                skipped_entries += 1
                continue

            # Iterate over each car's data within that lap
            for key, value in lap_session_data.items():
                if key.startswith("lap_") and isinstance(value, dict):
                    try:
                        team_name = value['name']
                        lap_position = value['lap_position']
                        # Use explicit lap_number if provided, else use index-based ID
                        lap_number = value.get('lap_number', lap_index + 1)
                        lap_id = f'lap_{lap_number}'

                        # Initialize team entry if not present
                        if team_name not in team_lap_positions:
                            team_lap_positions[team_name] = []

                        # Append lap data as a dictionary
                        team_lap_positions[team_name].append({
                            'lap_id': lap_id,
                            'position': lap_position
                        })
                    except KeyError as e:
                        print(f"Warning: Skipping lap entry {lap_index + 1}, key {key} missing field: {e}")
                        skipped_entries += 1
                        continue
                else:
                    print(f"Warning: Key {key} in lap entry {lap_index + 1} does not start with 'lap_' or is not a dict.")
                    skipped_entries += 1

    else:
        print("Error: 'lapData' not found in JSON or is not a list.")
        return None, 0

    if skipped_entries > 0:
        print(f"Skipped {skipped_entries} invalid or incomplete lap entries.")
    print(f"Processed {lap_count - skipped_entries} valid lap entries for {len(team_lap_positions)} teams.")
    return team_lap_positions, lap_count

def export_to_json(data, file_path):
    """
    Exports the processed lap data to a JSON file, with lap entries sorted by lap_id.

    Args:
        data (dict): The data to export.
        file_path (str): The path for the output JSON file.
    """
    if not data:
        print("No data to export to JSON.")
        return

    # Create a sorted version of the data
    sorted_data = {}
    for team, lap_entries in data.items():
        # Sort lap entries by the numeric part of lap_id (e.g., lap_1 -> 1)
        sorted_entries = sorted(
            lap_entries,
            key=lambda x: int(re.search(r'\d+', x['lap_id']).group())
        )
        sorted_data[team] = sorted_entries

    try:
        with open(file_path, 'w', encoding='utf-8') as f:
            json.dump(sorted_data, f, indent=4)
        print(f"✅ Successfully exported sorted data to '{file_path}'")
    except IOError:
        print(f"❌ Error: Could not write to the file '{file_path}'.")

def export_to_csv(data, file_path, total_laps):
    """
    Exports the processed lap data to a CSV file with laps as columns.

    Args:
        data (dict): The data to export.
        file_path (str): The path for the output CSV file.
        total_laps (int): The total number of lap entries to create columns for.
    """
    if not data:
        print("No data to export to CSV.")
        return

    # Create the header row: ['Team', 'lap_1', 'lap_2', ...]
    header = ['Team'] + [f'lap_{i+1}' for i in range(total_laps)]

    try:
        with open(file_path, 'w', newline='', encoding='utf-8') as f:
            writer = csv.writer(f)
            writer.writerow(header)

            # Write the data for each team
            for team, lap_entries in data.items():
                row = [team]
                # Create a dictionary to map lap_id to position for this team
                lap_positions = {}
                for entry in lap_entries:
                    # Store the last position for each lap_id (in case of duplicates)
                    lap_positions[entry['lap_id']] = entry['position']
                # For each lap column, find the team's position
                for i in range(total_laps):
                    lap_key = f'lap_{i+1}'
                    position = lap_positions.get(lap_key, '')
                    row.append(position)
                writer.writerow(row)
        print(f"✅ Successfully exported data to '{file_path}'")
    except IOError:
        print(f"❌ Error: Could not write to the file '{file_path}'.")

# --- Main Execution ---
input_file = 'input.json'
lap_data, num_laps = process_lap_data(input_file)

if lap_data:
    # Export to JSON
    export_to_json(lap_data, 'lap_positions_by_lap.json')

    # Export to CSV
    export_to_csv(lap_data, 'lap_positions_by_lap.csv', num_laps)
else:
    print("No data was processed, skipping export.")