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













