import json
import os

def filter_position_keys(input_file, output_file):
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

        # Initialize filtered data with lapData if it exists
        filtered_data = {}
        if 'lapData' in data:
            print(f"DEBUG: Found 'lapData' with {len(data['lapData'])} entries.")
            filtered_lap_data = []
            for lap_entry in data['lapData']:
                filtered_entry = {}
                # Get all keys in the lap entry
                lap_keys = list(lap_entry.keys())
                print(f"DEBUG: Processing lap entry with keys: {lap_keys}")
                
                for key in lap_keys:
                    # Keep lap_1 and lap_2 entirely
                    if key in ['lap_1', 'lap_2']:
                        filtered_entry[key] = lap_entry[key]
                        print(f"DEBUG: Kept entire key '{key}'")
                    # For other lap_* keys, keep only lap_position
                    elif key.startswith('lap_') and key not in ['lap_1', 'lap_2']:
                        lap_position = lap_entry[key].get('lap_position')
                        filtered_entry[key] = {'lap_position': lap_position}
                        print(f"DEBUG: Kept 'lap_position' for '{key}': {lap_position}")
                    # For non-lap keys (e.g., finishing_position), keep only keys with "position"
                    elif 'position' in key.lower():
                        if isinstance(lap_entry[key], dict):
                            filtered_entry[key] = {
                                k: v for k, v in lap_entry[key].items() if 'position' in k.lower()
                            }
                            print(f"DEBUG: Filtered '{key}' to keep position keys: {list(filtered_entry[key].keys())}")
                        else:
                            filtered_entry[key] = lap_entry[key]
                            print(f"DEBUG: Kept non-dict '{key}': {lap_entry[key]}")
                    else:
                        print(f"DEBUG: Removed key '{key}' (no 'position' in name)")

                if filtered_entry:
                    filtered_lap_data.append(filtered_entry)
                    print("DEBUG: Added filtered entry to lapData")
                else:
                    print("DEBUG: No keys kept for this lap entry")

            filtered_data['lapData'] = filtered_lap_data
        else:
            print("DEBUG: No 'lapData' key found in input JSON")

        # Add any other top-level keys that contain "position"
        for key, value in data.items():
            if key != 'lapData' and 'position' in key.lower():
                filtered_data[key] = value
                print(f"DEBUG: Kept top-level key '{key}'")

        print(f"DEBUG: Final filtered data keys: {list(filtered_data.keys())}")
        if not filtered_data:
            print("WARNING: Filtered data is empty. Writing empty JSON object to output.")
            filtered_data = {}

        # Write the filtered data to a new JSON file
        with open(output_file, 'w', encoding='utf-8') as file:
            json.dump(filtered_data, file, indent=4)
        print(f"Filtered data written to '{output_file}'")

    except json.JSONDecodeError:
        print("Error: The input file is not a valid JSON file.")
    except UnicodeDecodeError as e:
        print(f"Encoding error: {str(e)}. Try using 'utf-8-sig' or 'latin1' encoding.")
    except Exception as e:
        print(f"An error occurred: {str(e)}")

# Example usage
if __name__ == "__main__":
    input_file = r"C:\Users\Marc Mas\Documents\Code\Other\PLM\input.json"
    output_file = r"C:\Users\Marc Mas\Documents\Code\Other\PLM\output.json"
    filter_position_keys(input_file, output_file)