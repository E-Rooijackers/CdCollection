## Welcome to GitHub Pages

##############################################################################################################################################################################################################

How to:

>>>stap 1:

Open "cmd.exe" en ga met het "cd" command + de juiste map naar de goede directory waar u de files heeft geplaatst.
Bijvoorbeeld "cd Users" om naar "c:\Users>" te gaan.

>>>stap 2:

Als u bij de goede map bent aangekomen voert u het volgende command in: 
	"javac -cp .;lib/mysql-connector-java-5.1.47.jar CdCollector.java"
Het volledige command zou er dus als volgt uit moeten zien, waarbij u de goede directory :
	C:\HET\PAD\NAAR\DE\FILES>javac -cp .;lib/mysql-connector-java-5.1.47.jar CdCollector.java 
Dit command compileert de .java files naar .class files zodat u ze in stap 3 kunt uitvoeren

>>>stap 3:
 
Na de compilatie van de files in stap 2, kunt u de files uitvoeren met het volgende command:
	java -cp .;lib/mysql-connector-java-5.1.47.jar CdCollector
Ook hier geldt, het volledige command moet er als volgt uit zien:
	C:\HET\PAD\NAAR\DE\FILES>java -cp .;lib/mysql-connector-java-5.1.47.jar CdCollector
Als dit de eerste keer is dat u dit programma opstart dan zult u een melding krijgen, dat u een nieuwe database moet aanmaken voor de optimale 
beleving van het programma. Doorloop dit process en u kunt de applicatie gebruiken naar behoren. 