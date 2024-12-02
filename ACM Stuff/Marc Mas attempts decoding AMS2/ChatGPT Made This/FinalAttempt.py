# Loading the uploaded files to inspect their content and structure

file_path1 = 'E:/00USF/DOCUMENTS/Code/ACM Stuff/Marc Mas attempts decoding AMS2/Ginetta GT3 Goiania/tso55nqbbliy22oabbga.vts'



file_path2 = "E:/00USF/DOCUMENTS/Code/ACM Stuff/Marc Mas attempts decoding AMS2/Ginetta GT3 Goiania/tso55nqbbum7xjeabbga.vts"

# Let's check the file types and see the first few bytes to identify the format.
file_info1 = {"path": file_path1}
file_info2 = {"path": file_path2}

with open(file_path1, 'rb') as file1, open(file_path2, 'rb') as file2:
    file_info1["header"] = file1.read(100)  # Read first 100 bytes
    file_info2["header"] = file2.read(100)

file_info1, file_info2


import binascii

# Analyzing the first 100 bytes of each file as hex to better understand the data structure.
hex_header1 = binascii.hexlify(file_info1["header"]).decode('utf-8')
hex_header2 = binascii.hexlify(file_info2["header"]).decode('utf-8')

# Compare the two headers to see if there are common patterns or markers.
hex_header1, hex_header2

# Analyzing the complete file contents to identify potential patterns, sizes, or delimiters.

# Read the entire files to analyze their structures.
with open(file_path1, 'rb') as file1, open(file_path2, 'rb') as file2:
    content1 = file1.read()
    content2 = file2.read()

# Check the sizes and compare the two files for similarity.
len_content1 = len(content1)
len_content2 = len(content2)
content_comparison = content1[:200] == content2[:200]  # Compare the first 200 bytes as a sample

len_content1, len_content2, content_comparison

# Comparing the first 500 bytes of the two files to identify patterns or regions with consistent structures.
sample_size = 500
hex_content1 = binascii.hexlify(content1[:sample_size]).decode('utf-8')
hex_content2 = binascii.hexlify(content2[:sample_size]).decode('utf-8')

# Find regions of similarity and differences.
similarity_regions = [hex_content1[i:i+16] == hex_content2[i:i+16] for i in range(0, sample_size*2, 16)]

# Output sample similarity and a brief region from each file for inspection.
similarity_summary = {
    "similar": sum(similarity_regions),
    "different": len(similarity_regions) - sum(similarity_regions),
}

hex_content1[:256], hex_content2[:256], similarity_summary

print(similarity_regions)
print(hex_header1)
print(hex_header2)

print(hex_content1[:256], hex_content2[:256], similarity_summary)

print(len_content1, len_content2, content_comparison)