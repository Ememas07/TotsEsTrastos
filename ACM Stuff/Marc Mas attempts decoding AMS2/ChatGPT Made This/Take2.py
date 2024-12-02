import struct
import binascii
import json

# Analyze binary structure
def analyze_binary_structure(file_path):
    with open(file_path, 'rb') as file:
        content = file.read()
    
    # File info
    file_size = len(content)
    print(f"File size: {file_size} bytes")
    
    # Display first 256 bytes as hex
    hex_data = binascii.hexlify(content[:256]).decode('utf-8')
    print(f"First 256 bytes (hex):\n{hex_data}\n")
    
    # Return full content for further processing
    return content

# Attempt to decode the file as structured data
def decode_setup_data(content):
    offset = 0
    decoded_data = []

    try:
        while offset < len(content):
            # Example structure: float and integer
            # Adjust '<fI' for the actual format (e.g., floats, ints, or strings)
            float_value = struct.unpack_from('<f', content, offset)[0]
            int_value = struct.unpack_from('<I', content, offset + 4)[0]
            decoded_data.append({'float': float_value, 'int': int_value})
            
            # Move to the next record
            offset += 8
    except struct.error:
        print("End of file or misalignment.")
    
    return decoded_data

# Save decoded data to JSON
def save_to_json(data, output_path):
    with open(output_path, 'w') as json_file:
        json.dump(data, json_file, indent=4)
    print(f"Decoded data saved to {output_path}")

# Main execution
if __name__ == "__main__":
    file_path = "E:/00USF/DOCUMENTS/Code/ACM Stuff/Marc Mas attempts decoding AMS2/Ginetta GT3 Goiania/tso55nqbbliy22oabbga.vts"  # Replace with your file path
    output_path = "E:/00USF/DOCUMENTS/Code/ACM Stuff/Marc Mas attempts decoding AMS2/ChatGPT Made This/decoded_setup.json"
    
    # Analyze the binary file
    content = analyze_binary_structure(file_path)
    
    # Decode the binary data
    decoded_data = decode_setup_data(content)
    print(f"Sample decoded data:\n{decoded_data[:10]}")  # Show first 10 entries
    
    # Save the data to a readable format
    save_to_json(decoded_data, output_path)
