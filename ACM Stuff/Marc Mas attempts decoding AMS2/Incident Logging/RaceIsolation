import json

# Load the JSON file
input_file = "E:/00USF/DOCUMENTS/Code/ACM Stuff/Marc Mas attempts decoding AMS2/Incident Logging/241130_184400_AMS2.json"
output_file = "E:/00USF/DOCUMENTS/Code/ACM Stuff/Marc Mas attempts decoding AMS2/Incident Logging/outputOnlyrace1.json"

with open(input_file, "r") as file:
    data = json.load(file)

# Keep only the "race" stage
if "stages" in data and "race1" in data["stages"]:
    race1_stage = {"stages": {"race1": data["stages"]["race1"]}}
else:
    race1_stage = {}

# Save the reduced JSON with only the "race1" stage
with open(output_file, "w") as file:
    json.dump(race1_stage, file, indent=4)

print(f"JSON reduced to only the 'race1' stage and saved to {output_file}.")
