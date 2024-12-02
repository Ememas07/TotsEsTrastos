import json

# Load the JSON file
input_file = "E:/00USF/DOCUMENTS/Code/ACM Stuff/Marc Mas attempts decoding AMS2/Incident Logging/241130_184400_AMS2.json"
output_file = "E:/00USF/DOCUMENTS/Code/ACM Stuff/Marc Mas attempts decoding AMS2/Incident Logging/outputOnlyRace1Crashes.json"

with open(input_file, "r") as file:
    data = json.load(file)

# Function to filter events
def filter_race1_events(events):
    return [
        event for event in events
        if event.get("event_name") == "Impact" #and
           #event.get("attributes", {}).get("OtherParticipantId") != -1
    ]

# Keep only the filtered "race1" stage
if "stages" in data and "race1" in data["stages"]:
    race1_stage = data["stages"]["race1"]
    if "events" in race1_stage:
        race1_stage["events"] = filter_race1_events(race1_stage["events"])
    reduced_data = {"stages": {"race1": race1_stage}}
else:
    reduced_data = {}

# Save the reduced and filtered JSON
with open(output_file, "w") as file:
    json.dump(reduced_data, file, indent=4)

print(f"Filtered race1 stage saved to {output_file}.")
