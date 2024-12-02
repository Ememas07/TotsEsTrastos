import json

# Load the JSON file
input_file = "E:/00USF/DOCUMENTS/Code/ACM Stuff/Marc Mas attempts decoding AMS2/Incident Logging/input.json"
output_file = "E:/00USF/DOCUMENTS/Code/ACM Stuff/Marc Mas attempts decoding AMS2/Incident Logging/outputTimeStamps.json"

with open(input_file, "r") as file:
    data = json.load(file)

# Function to normalize "time" in nested events
def normalize_event_times(events):
    if not events:
        return
    # Extract all "time" values
    times = [event["time"] for event in events if "time" in event]
    if times:
        first_time = times[0]
        # Adjust each "time" value
        for event in events:
            if "time" in event:
                event["time"] -= first_time

# Traverse the JSON structure to find "events"
if "stages" in data:
    for stage_name, stage_data in data["stages"].items():
        if "events" in stage_data:
            normalize_event_times(stage_data["events"])

# Save the adjusted JSON back to a file
with open(output_file, "w") as file:
    json.dump(data, file, indent=4)

print(f"Updated JSON saved to {output_file}.")
