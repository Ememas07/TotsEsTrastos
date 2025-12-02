import pygame
import asyncio
import platform
import textwrap
import random
from questions_formatted_two import questions  # Import the questions list
# Initialize Pygame
pygame.init()

# Screen dimensions
WIDTH = 800
HEIGHT = 600
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Juego de Cuestionario Médico")

# Colors
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
GRAY = (200, 200, 200)
DARK_GRAY = (100, 100, 100)
BLUE = (70, 130, 180)
HOVER_BLUE = (100, 160, 210)
GREEN = (0, 255, 0)
RED = (255, 0, 0)
LIGHT_GRAY = (240, 240, 240)

# Fonts
QUESTION_FONT = pygame.font.SysFont("Arial", 24)
OPTION_FONT = pygame.font.SysFont("Arial", 20)
SCORE_FONT = pygame.font.SysFont("Arial", 22)

# Game variables
score = 0
current_question = 0
selected_option = None
feedback_timer = 0
feedback_duration = 0.5  # Default, will be set dynamically
game_over = False

# Button properties
BUTTON_WIDTH = 700
BUTTON_HEIGHT = 50
BUTTON_MARGIN = 10
BUTTON_X = (WIDTH - BUTTON_WIDTH) // 2
BUTTON_Y_START = 300

def wrap_text(text, font, max_width):
    """Wrap text to fit within max_width, returning a list of lines."""
    lines = []
    words = text.split(" ")
    current_line = ""
    for word in words:
        test_line = current_line + word + " "
        if font.size(test_line)[0] <= max_width:
            current_line = test_line
        else:
            lines.append(current_line.strip())
            current_line = word + " "
    if current_line:
        lines.append(current_line.strip())
    return lines

def draw_button(screen, text, x, y, width, height, color, hover_color, font, mouse_pos):
    """Draw a button, returning True if mouse is over it."""
    rect = pygame.Rect(x, y, width, height)
    is_hovered = rect.collidepoint(mouse_pos)
    pygame.draw.rect(screen, hover_color if is_hovered else color, rect, border_radius=10)
    text_surf = font.render(text, True, WHITE)
    text_rect = text_surf.get_rect(center=rect.center)
    screen.blit(text_surf, text_rect)
    return is_hovered

def setup():
    global score, current_question, game_over, selected_option, feedback_timer
    score = 0
    current_question = 0
    game_over = False
    selected_option = None
    feedback_timer = 0
    random.shuffle(questions)  # Randomize questions

def update_loop():
    global score, current_question, selected_option, feedback_timer, game_over
    if game_over:
        return

    current_time = pygame.time.get_ticks() / 1000
    if feedback_timer > 0 and current_time > feedback_timer + feedback_duration:
        selected_option = None
        feedback_timer = 0
        current_question += 1
        if current_question >= len(questions):
            game_over = True

def draw():
    global feedback_timer
    screen.fill(LIGHT_GRAY)  # Background
    mouse_pos = pygame.mouse.get_pos()

    if game_over:
        # Game Over Screen
        text = SCORE_FONT.render(f"¡Juego Terminado! Puntuación Final: {score:.2f}", True, BLACK)
        text_rect = text.get_rect(center=(WIDTH // 2, HEIGHT // 2 - 20))
        screen.blit(text, text_rect)
        if draw_button(screen, "Reiniciar", WIDTH // 2 - 100, HEIGHT // 2 + 20, 200, 50, BLUE, HOVER_BLUE, SCORE_FONT, mouse_pos):
            if pygame.mouse.get_pressed()[0]:
                setup()
        return

    # Draw Score
    score_text = SCORE_FONT.render(f"Puntuación: {score:.2f}", True, BLACK)
    screen.blit(score_text, (10, 10))

    # Draw Question
    question = questions[current_question]["text"]
    wrapped_question = wrap_text(question, QUESTION_FONT, WIDTH - 40)
    for i, line in enumerate(wrapped_question):
        text_surf = QUESTION_FONT.render(line, True, BLACK)
        screen.blit(text_surf, (20, 50 + i * 30))

    # Draw Options as Buttons
    correct_answer = questions[current_question]["correct"]
    for i, option in enumerate(questions[current_question]["options"]):
        y_pos = BUTTON_Y_START + i * (BUTTON_HEIGHT + BUTTON_MARGIN)
        is_hovered = draw_button(screen, option, BUTTON_X, y_pos, BUTTON_WIDTH, BUTTON_HEIGHT, BLUE, HOVER_BLUE, OPTION_FONT, mouse_pos)
        if selected_option is not None:
            # Highlight selected option
            if option == selected_option:
                color = GREEN if option == correct_answer else RED
                pygame.draw.rect(screen, color, (BUTTON_X, y_pos, BUTTON_WIDTH, BUTTON_HEIGHT), 3, border_radius=10)
            # Highlight correct answer if selected option is incorrect
            elif option == correct_answer and selected_option != correct_answer:
                pygame.draw.rect(screen, GREEN, (BUTTON_X, y_pos, BUTTON_WIDTH, BUTTON_HEIGHT), 3, border_radius=10)

def handle_event(event):
    global selected_option, score, feedback_timer, feedback_duration
    if game_over and event.type == pygame.MOUSEBUTTONDOWN:
        return  # Handled in draw()

    if event.type == pygame.MOUSEBUTTONDOWN and selected_option is None:
        mouse_pos = event.pos
        for i, option in enumerate(questions[current_question]["options"]):
            y_pos = BUTTON_Y_START + i * (BUTTON_HEIGHT + BUTTON_MARGIN)
            rect = pygame.Rect(BUTTON_X, y_pos, BUTTON_WIDTH, BUTTON_HEIGHT)
            if rect.collidepoint(mouse_pos):
                selected_option = option
                correct_answer = questions[current_question]["correct"]
                if selected_option == correct_answer:
                    score += 1
                    feedback_duration = 0.5  # 0.5 seconds for correct
                else:
                    score -= 0.25
                    feedback_duration = 1.0  # 1 second for incorrect
                feedback_timer = pygame.time.get_ticks() / 1000

async def main():
    setup()
    clock = pygame.time.Clock()
    FPS = 60
    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                return
            handle_event(event)
        update_loop()
        draw()
        pygame.display.flip()
        clock.tick(FPS)
        await asyncio.sleep(1.0 / FPS)

if platform.system() == "Emscripten":
    asyncio.ensure_future(main())
else:
    if __name__ == "__main__":
        asyncio.run(main())