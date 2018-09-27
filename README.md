## Welcome to GitHub Pages

You can use the [editor on GitHub](https://github.com/E-Rooijackers/CdCollection/edit/master/README.md) to maintain and preview the content for your website in Markdown files.

Whenever you commit to this repository, GitHub Pages will run [Jekyll](https://jekyllrb.com/) to rebuild the pages in your site, from the content in your Markdown files.

### Markdown

Markdown is a lightweight and easy-to-use syntax for styling your writing. It includes conventions for

```markdown
Syntax highlighted code block

# Header 1
## Header 2
### Header 3

- Bulleted
- List

1. Numbered
2. List

**Bold** and _Italic_ and `Code` text

[Link](url) and ![Image](src)
```

For more details see [GitHub Flavored Markdown](https://guides.github.com/features/mastering-markdown/).

### Jekyll Themes

Your Pages site will use the layout and styles from the Jekyll theme you have selected in your [repository settings](https://github.com/E-Rooijackers/CdCollection/settings). The name of this theme is saved in the Jekyll `_config.yml` configuration file.

### Support or Contact

Having trouble with Pages? Check out our [documentation](https://help.github.com/categories/github-pages-basics/) or [contact support](https://github.com/contact) and we’ll help you sort it out.

##############################################################################################################################################################################################################

How to:

>>>stap 1:

open "cmd.exe" en ga met het "cd" command + de juiste map naar de goede directory waar u de files heeft geplaatst.
bijvoorbeeld "cd Users" om naar "c:\Users>" te gaan.

>>>stap 2:

als u bij de goede map bent aangekomen voert u het volgende command in: 
	"javac -cp .;mysql-connector-java-5.1.47.jar CdCollector.java"
het volledige command zou er dus als volgt uit moeten zien, waarbij u de goede directory :
	C:\HET\PAD\NAAR\DE\FILES>javac -cp .;mysql-connector-java-5.1.47.jar CdCollector.java 
dit command compileert de .java files naar .class files zodat u ze in stap 3 kunt uitvoeren

>>>stap 3:
 
na de compilatie van de files in stap 2, kunt u de files uitvoeren met het volgende command:
	java -cp .;mysql-connector-java-5.1.47.jar CdCollector
Ook hier geldt, het volledige command moet er als volgt uit zien:
	C:\HET\PAD\NAAR\DE\FILES>java -cp .;mysql-connector-java-5.1.47.jar CdCollector
Als dit de eerste keer is dat u dit programma opstart dan zult u een melding krijgen, dat u een nieuwe database moet aanmaken voor de optimale 
beleving van het programma. Doorloop dit process en u kunt de applicatie gebruiken naar behoren. 




