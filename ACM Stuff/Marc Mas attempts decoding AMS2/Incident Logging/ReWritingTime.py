import json

# Function to convert seconds to "mm:ss" format
def convert_seconds_to_readable_format(seconds):
    minutes = seconds // 60
    seconds = seconds % 60
    return f"{minutes:02}:{seconds:02}"

# Load the JSON file
input_file = "E:/00USF/DOCUMENTS/Code/ACM Stuff/Marc Mas attempts decoding AMS2/Incident Logging/241130_184400_AMS2.json"
output_file = "E:/00USF/DOCUMENTS/Code/ACM Stuff/Marc Mas attempts decoding AMS2/Incident Logging/ReWritingTime2.json"

with open(input_file, "r") as file:
    data = json.load(file)

# Function to normalize timestamps and filter "Impact" events
def normalize_and_filter_impact_events(events, start_time):
    filtered_events = []
    for event in events:
        if event.get("event_name") == "Impact":
            other_participant_id = event.get("attributes", {}).get("OtherParticipantId")
            if other_participant_id != -1:  # Only include events where OtherParticipantId is not 0
                # Normalize the "time" field
                if "time" in event:
                    event["time"] -= start_time
                    # Convert the "time" field to a readable format and add it as a new field
                    event["time in readable format"] = convert_seconds_to_readable_format(event["time"])
                filtered_events.append(event)
    return filtered_events

# Get the start time from the data
start_time = data.get("start_time", 0)

# Check if "race1" stage exists and filter the events
if "stages" in data and "race1" in data["stages"]:
    race1_stage = data["stages"]["race1"]
    if "events" in race1_stage:
        race1_stage["events"] = normalize_and_filter_impact_events(race1_stage["events"], start_time)
    reduced_data = {"stages": {"race1": race1_stage}}
else:
    reduced_data = {}

# Normalize the top-level "start_time" to 0
data["start_time"] = 0

# Save the filtered and normalized JSON with the readable time
with open(output_file, "w") as file:
    json.dump(reduced_data, file, indent=4)

print(f"Filtered and normalized 'Impact' events with readable time saved to {output_file}.")