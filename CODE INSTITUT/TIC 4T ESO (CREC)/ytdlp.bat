set /p choice=link
yt-dlp -x --audio-format mp3 --paths "C:\Users\Marc Mas\Downloads\YT-DLP" %choice%
PAUSE
