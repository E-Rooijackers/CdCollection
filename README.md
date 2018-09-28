>>>stap 1:
installeer eerst de sql database door het sql bestand in phpmyadmin te importeren.


>>>stap 2:
open de cmd prompt en u ziet het volgende:
	"C:\"
gebruik vervolgens het "cd" command om de juiste map te selecteren waar de java bestanden staan. 
zo zal "cd Users" u naar de users map brengen en ziet u: 
	"C:\Users"

>>>stap 3:
Zodra u dus bij de map bent typ u het volgende command:
	"javac -cp .;lib/* CdCollector.java"
De commandline zal er dus als volgt uitzien.
	"C:\DE\MAP\MET\BESTANDEN>javac -cp .;lib/* CdCollector.java"
druk op enter en wacht totdat de computer klaar is om de bestanden te compilen en u weer dingen in kunt vullen.

>>>stap4:
typ nu het volgende command in:
	"java -cp .;lib/* CdCollector"
u ziet dus:
	"C:\Users\Merli\Documents\GIT\CdCollection>java -cp .;lib/* CdCollector"
druk op enter en het programma zou nu moeten openen.

>>>stap 5:

Geniet.