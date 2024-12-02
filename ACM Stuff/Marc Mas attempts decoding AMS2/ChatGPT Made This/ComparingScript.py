import binascii


# Function to read a binary file and display details
def analyze_file(file_path):
    with open(file_path, 'rb') as file:
        content = file.read()
    
    # General file info
    file_size = len(content)
    header = content[:100]
    
    print(f"File: {file_path}")
    print(f"Size: {file_size} bytes")
    print(f"Header (first 100 bytes as hex): {binascii.hexlify(header).decode('utf-8')}")
    print()
    return content

# Function to compare two files
def compare_files(content1, content2, sample_size=3000):
    hex1 = binascii.hexlify(content1[:sample_size]).decode('utf-8')
    hex2 = binascii.hexlify(content2[:sample_size]).decode('utf-8')
    
    print("First 500 bytes comparison:")
    for i in range(0, len(hex1), 16):
        chunk1 = hex1[i:i+16]
        chunk2 = hex2[i:i+16]
        if chunk1 == chunk2:
            print(f"Match:   {chunk1}")
        else:
            print(f"Differs: {chunk1} vs {chunk2}")
    print()

# Main logic
if __name__ == "__main__":
    # Replace with your file paths
    file_path1 = 'E:/00USF/DOCUMENTS/Code/ACM Stuff/Marc Mas attempts decoding AMS2/Ginetta GT3 Goiania/tso55nqbbliy22oabbga.vts'
    file_path2 = "E:/00USF/DOCUMENTS/Code/ACM Stuff/Marc Mas attempts decoding AMS2/Ginetta GT3 Goiania/tso55nqbbum7xjeabbga.vts"

    
    content1 = analyze_file(file_path1)
    content2 = analyze_file(file_path2)
    
    compare_files(content1, content2)
