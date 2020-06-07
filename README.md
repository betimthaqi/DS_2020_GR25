
# **Projekti në lëndën 'Siguria e të dhënave'**



## Qëllimi
Qëllimi i këtij projekti është që të krijohet një aplikacion lehtë i ekzekutueshëm dhe lehtë i përdorshëm per enkriptim dhe dekriptim.

## Ekzekutimi dhe kompajllimi i programit

 - Që programi jonë  të  ekzekutohet duhet që të shkarkoni atë përmes butonit download si dhe të gjithë fajllat të jenë në një follder të njëjtë.
 ![enter image description here](https://images2.imagebam.com/fe/63/60/cee4aa1346101316.png)
 - Programi jonë mund të ekzekutohet nga Command Line ose GitBash nese e keni te instaluar (qofse deshironi ta instaloni klikoni [ketu](https://git-scm.com/downloads)). Në do të tregojmë si ekzekutohet sipas GitBash, krejtësisht njëjtë shkon pocedura edhe me CommandLine.
 - Pasi që projekti e metodat për implementimin e JWT (Json Web Token) janë krijuar përmes Maven Project është përdorur vegla Maven për agregimin (mbledhjen) e tërë programit me të gjitha libraritë (dependecies) në një fajll të vetëm (DS.jar).
 - Fillimisht duhet që në Git Bash të çasemi në follderin ku e kemi të ruajtur fajllin "DS.jar", në shembullin e mëposhtëm shihet qartë se si bëhet kjo.
 

> ![enter image description
> here](https://images2.imagebam.com/7c/ed/3f/e888fa1346101318.png)

 - Pas kësaj - përmes komandave `java -jar` thirret fajlli DS.jar (i cili përmban programin) dhe si rezultat i argumenteve që pasojnë sipas kerkesave, programi ekzekuton ndonjërën prej komandave specifike. Shih figurën më poshtë.

> ![enter image description
> here](https://images2.imagebam.com/40/fe/d2/c0b87f1346101320.png)

Për të parë se çfarë kërkesa plotëson programi jonë shikojeni përmbajtjen.

## Permbajtja
Progami jonë mundëson të bëhen enkriptime dhe dekriptime sipas algoritmeve të ndryshme.
Më poshtë do të shihni se qfarë komanda përmban programi jonë dhe sintaksa se si thirren ato përmes GitBash:<br>

<br>**Komanda Create-user** <br>
Krijon një çift të publik/privat të RSA me emrat <name>.xml dhe <name>.pub.xml brenda direktoriumit të çelësave keys si dhe ruan shfrytëzuesin e caktuar (së bashku me fjalëkalimin e enkriptuar përmes hash funksioneve) në fajllin "login.txt".

>     java -jar ds.jar create-user <name>
> ![enter image description
> here](https://images2.imagebam.com/80/11/07/8fa8c01346101309.png)

<br>**Komanda Delete-user** <br>
I largon të gjithë çelësat ekzistues të shfrytëzuesit si dhe të gjitha të dhënat e shfrytëzuesit nga baza e të dhënave(përkatësisht nga fajlli login.txt). 

>     java -jar ds.jar delete-user <name> 
> ![enter image description
> here](https://images2.imagebam.com/c0/6f/c0/e906a61346101311.png)

<br>**Komanda Login** <br>
Teston çiftin shfrytëzues/fjalëkalim. Në rast suksesi, lëshohet tokeni i nënshkruar i cili shërben për autorizimin dhe autentikimin e shfrytëzuesit në aplikacion.
  >     java -jar ds.jar login <name> 
> ![enter image description
> here](https://images2.imagebam.com/a5/7e/39/2cb21c1346101325.png)

  
  <br> **Komanda Status** <br>
Jep informata rreth tokenit. 
  >     java -jar ds.jar status <token> 
> ![enter image description
> here](https://images2.imagebam.com/72/b5/28/aa38c01346101333.png)

<br> **Komanda Export-key** <br>
Eksporton çelësin publik ose privat të shfrytëzuesit nga direktoriumi i çelësave

>     java -jar ds.jar export-key <public|private> <name> [file] 
> ![enter image description
> here](https://images2.imagebam.com/61/61/ae/bd49fc1346101314.png)

<br>**Komanda Import-key** <br>
Importon çelësin publik ose privat të shfrytëzuesit nga shtegu i dhënë dhe e vendos në direktoriumin e çelësave. 

>     java -jar ds.jar import-key <name> <path>
> ![enter image description
> here](https://images2.imagebam.com/07/83/02/efc7ed1346101322.png)

<br>**Komanda Write-message** <br>
E shkruan një mesazh të enkriptuar të dedikuar për një shfrytëzues, gjithashtu mund ta pranojë edhe opsionin --sender. Vlera sender është emri i shfrytëzuesit që i korrespondon tokenit token.

>     java -jar ds.jar write-message <name> <message> [file]
> ![enter image description
> here](https://images2.imagebam.com/f3/62/9f/9795eb1346101341.png)

<br>**Komanda Read-message** <br>
E dekripton dhe e shfaq në console mesazhin e enkriptuar, gjithashtu nëse figuron pjesa e dërguesit/nënshkrimit në mesazh, atëherë do të tentohet verifikimi i atij nënshkrimi duke përdorur çelësin publik të dërguesit.

>     java -jar ds.jar read-message <encrypted-message>
> ![enter image description
> here](https://images2.imagebam.com/b2/33/14/d0fcbf1346101332.png)

<br>
Gjithashtu programi jonë përmban edhe tri komanda tjera për enkriptime dhe dekriptime. 

<br>

**Komanda Numerical** <br>
 Është e ndarë në dy nënkomanda, encode dhe decode.

Nënkomanda encode
Enkodon tekstin <text> në pozitat alfabetike të shkronjave.

>     java -jar ds.jar numerical encode <text>
> 
> ![enter image description
> here](https://images2.imagebam.com/0b/1d/d1/aabba71346101327.png)

Nënkomanda decode
Dekodon vargun < code> nga shifrat në shkronjat përkatëse.

>     java -jar ds.jar numerical decode <code>
> 
> ![enter image description
> here](https://images2.imagebam.com/ae/5f/1d/0815951346101328.png)

Gjithashtu te enkodimi kemi mundësi të zgjedhim opsionin "--separator" ku hapësirat në fjali të zëvendësohen me karakterin që dëshirojmë.

>     java -jar ds.jar numerical encode <text> --separator <char>
> ![enter image description
> here](https://images2.imagebam.com/f2/5b/f4/8d01c51346101330.png)

 
<br>**Komanda Case** <br>
E konverton tekstin < text> në madhësinë e dhënë < case>, e cila mund të jetë: lower, upper, capitalize, inverse, alternating.

>     java -jar ds.jar case <case> <text>
> ![enter image description
> here](https://images2.imagebam.com/8f/27/72/1145381346101307.png)

Nenkomanda sentence konverton secilën shkronjë të fjalisë e cila gjendet pas këtyre karaktereve si (.), (?), (/), (!).                     

> ![enter image description
> here](https://images2.imagebam.com/d8/ec/8f/ea9b411346101303.png)

<br>**Komanda Vigenere** <br>
Vigenère Cipher është version më i avancuar i Kodit të Cezarit pasi që përdor më shumë se një zhvendosjesiçelës. Lexo më shumë [ketu](https://www.braingle.com/brainteasers/codes/vigenere.php).
Perbehet nga dy nenkomanda, encryp dhe decrypt
 
Nenkomanda encrypt 

>     java -jar ds.jar vigenere encrypt <key> <plaintext> 
> ![enter image description
> here](https://images2.imagebam.com/26/09/4c/aa23081346101335.png)

Nenkomanda decrypt

>     java -jar ds.jar vigenere encrypt <key> <cipertext> 
> ![enter image description
> here](https://images2.imagebam.com/e1/79/a1/a55ff81346101338.png)

## Referencat
[Referencat](Referencat.md) për secilen fazë.
Gjithashtu një falenderim i veqant për [Edon Gashi](https://github.com/edongashi) që ishte i gatshëm për çdo paqartësi.

## License & Copyright
© Betim Thaçi, Çlirim Hodaj, Drinos Kukaj.  <br> University of Prishtina "Hasan Prishtina",  <br> Department: Computer Engineering.    <br>
Licensed under the [MIT License](LICENSE). 
