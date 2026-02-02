import re

def parse_question(question_string):
    # Extract question text (before options)
    question_match = re.match(r"(.*?)\n\s*a\)", question_string, re.DOTALL)
    question_text = question_match.group(1).strip() if question_match else ""
    
    # Extract options
    options = []
    option_matches = re.findall(r"([a-d]\)\s*.*?)(?=\n\s*[a-d]\)|$|\n\s*Respuesta correcta)", question_string, re.DOTALL)
    for opt in option_matches:
        options.append(opt.strip())
    
    # Extract correct answer
    correct_match = re.search(r"Respuesta correcta:\s*(.*?)(?:\s*\(.*?\))?$", question_string)
    correct_answer = correct_match.group(1).strip() if correct_match else ""
    
    return {
        "text": question_text,
        "options": options[:4],  # Ensure only 4 options
        "correct": correct_answer
    }

# Example usage for multiple questions
question_strings = [
    """¿Qué debe hacerse en un paciente con heridas graves?
 a) Controlar la hemorragia y trasladar al hospital
 b) Administrar analgésicos orales
 c) Observar en el domicilio
 d) Realizar un ECG de rutina
 Respuesta correcta: a) Controlar la hemorragia y trasladar al hospital (Basado en conocimiento clínico general)""",
 
    # Add your other 299 question strings here
]

questions = [parse_question(q) for q in question_strings]
print(questions)