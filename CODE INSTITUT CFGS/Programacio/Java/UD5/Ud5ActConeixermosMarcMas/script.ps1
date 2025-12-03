# $host.UI.RawUI.WindowSize = New-Object System.Management.Automation.Host.size(80,25)
$pshost = Get-Host              # Get the PowerShell Host.
$pswindow = $pshost.UI.RawUI    # Get the PowerShell Host's UI.

$newsize = $pswindow.BufferSize # Get the UI's current Buffer Size.
$newsize.width = 80          # Set the new buffer's width to 150 columns.
$pswindow.buffersize = $newsize # Set the new Buffer Size as active.

$newsize = $pswindow.windowsize # Get the UI's current Window Size.
$newsize.width = 25            # Set the new Window Width to 150 columns.
$pswindow.windowsize = $newsize # Set the new Window Size as active.
java -jar ./target/Ud5ActConeixermosMarcMas.jar