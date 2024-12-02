import struct


# Function to decode a binary file
def decode_automobilista2_setup(file_path):
    with open(file_path, 'rb') as file:
        content = file.read()

    # Example decoding logic (adjust based on actual structure)
    offset = 0
    decoded_data = []

    try:
        while offset < len(content):
            # Example: Read a float and an integer (adjust to your file format)
            float_value = struct.unpack_from('<f', content, offset)[0]
            int_value = struct.unpack_from('<I', content, offset + 4)[0]

            decoded_data.append({'float': float_value, 'int': int_value})

            # Move to the next record (adjust step size as needed)
            offset += 8
    except struct.error:
        print("Reached end of file or encountered misalignment.")

    return decoded_data

# Function to save decoded data to a readable format (e.g., JSON)
def save_to_json(data, output_path):
    import json
    with open(output_path, 'w') as json_file:
        json.dump(data, json_file, indent=4)
    print(f"Decoded data saved to {output_path}")

# Main logic
if __name__ == "__main__":
    # Replace with your file path
    file_path = "E:/00USF/DOCUMENTS/Code/ACM Stuff/Marc Mas attempts decoding AMS2/Ginetta GT3 Goiania/tso55nqbbum7xjeabbga.vts"
    output_path = "E:/00USF/DOCUMENTS/Code/ACM Stuff/Marc Mas attempts decoding AMS2/ChatGPT Made This/output2.json"

    decoded_data = decode_automobilista2_setup(file_path)
    save_to_json(decoded_data, output_path)

    # Print sample decoded data
    print("Sample decoded data:")
    for item in decoded_data[:10]:  # Show first 10 entries
        print(item)
