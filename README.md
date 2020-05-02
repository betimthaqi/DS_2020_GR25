
# **Projekti në lëndën 'Siguria e të dhënave'**



## Qëllimi
Qëllimi i këtij projekti është që të krijohet një aplikacion lehtë i ekzekutueshëm dhe lehtë i përdorshëm per enkriptim dhe dekriptim.

## Ekzekutimi dhe kompajllimi i programit

 - Që programi jonë  të  ekzekutohet duhet që të gjithë fajllat të jenë në një follder të njëjtë.
 - Programi jonë mund të ekzekutohet nga Command Line ose GitBash nese e keni te instaluar (qofse deshironi ta instaloni klikoni [ketu](https://git-scm.com/downloads)). Në do të tregojmë si ekzekutohet sipas GitBash, krejtësisht njëjtë shkon pocedura edhe me CommandLine.
 - Fillimisht duhet që në Git Bash të çasemi në folderin ku e kemi projektin, në shembullin më poshtë shihet qartë se si bëhet kjo.

> ![enter image description
> here](https://images2.imagebam.com/b0/06/0b/ae483b1342573259.png)

 - Me anë të komandës `javac` ne bëjmë kompajllimin e programit tonë të emëruar ds.java. 

> ![enter image description
> here](https://images2.imagebam.com/07/46/89/2181cd1342573261.png)

 - Pas kësaj - përmes komandave `java ds` dhe argumenteve që pasojnë, programi ekzekuton ndonjërën prej komandave specifike. 

> ![enter image description
> here](https://images2.imagebam.com/63/dc/96/6cf8941342573262.png)

Për të parë se çfarë kërkesa plotëson programi jonë shikojeni përmbajtjen.

## Permbajtja
Progami jonë mundëson të bëhen enkriptime dhe dektriptime sipas algoritmeve të ndryshme.
Më poshtë do të shihni se qfarë komanda përmban programi jonë dhe sintaksa se si thirren ato përmes GitBash:<br>

**Komanda Create-user**
Krijon një çift të publik/privat të RSA me emrat <name>.xml dhe <name>.pub.xml brenda direktoriumit të çelësave keys

>     java ds create-user <name>
> ![enter image description
> here](https://images2.imagebam.com/6d/57/a5/41334f1342573265.png)

**Komanda Delete-user**
I largon të gjithë çelësat ekzistues të shfrytëzuesit. 

>     java ds delete-user <name> 
> ![enter image description
> here](https://images2.imagebam.com/60/ea/a3/7b91081342573268.png)

**Komanda Export-key**
Eksporton çelësin publik ose privat të shfrytëzuesit nga direktoriumi i çelësave

>     java ds export-key <public|private> <name> [file] 
> ![enter image description
> here](https://images2.imagebam.com/d5/ca/f2/c251eb1342573271.png)

**Komanda Import-key**
Importon çelësin publik ose privat të shfrytëzuesit nga shtegu i dhënë dhe e vendos në direktoriumin e çelësave. 

>     java ds import-key <name> <path>
> ![enter image description
> here](https://images2.imagebam.com/bc/13/ff/b5fe141342573274.png)

**Komanda Write-message**
E shkruan një mesazh të enkriptuar të dedikuar për një shfrytëzues. 

>     java ds write-message <name> <message> [file]
> ![enter image description
> here](https://images2.imagebam.com/7e/f7/f1/c04b011342573278.png)

**Komanda Read-message**
E dekripton dhe e shfaq në console mesazhin e enkriptuar. 

>     java ds read-message <encrypted-message>
> ![enter image description
> here](https://images2.imagebam.com/0c/88/d7/5760e81342573280.png)

<br>
Gjithashtu programi jonë përmban edhe tri komanda tjera për enkriptime dhe dekriptime. 

<br>

**Komanda Numerical**
 Është e ndarë në dy nënkomanda, encode dhe decode.

Nënkomanda encode
Enkodon tekstin <text> në pozitat alfabetike të shkronjave.

>     java ds numerical encode <text>
>      
> ![enter image description
> here](https://images2.imagebam.com/49/78/b1/6b52d11338202361.jpg)

Nënkomanda decode 
Dekodon vargun < code> nga shifrat në shkronjat përkatëse.

>     java ds numerical decode <code>
>     
> ![enter image description
> here](https://images2.imagebam.com/07/09/7a/386c761338202356.jpg)

Gjithashtu te enkodimi kemi mundësi të zgjedhim opsionin "--separator" ku hapësirat në fjali të zëvendësohen me karakterin që dëshirojmë.
>     java ds numerical encode <text> --separator <char>
> ![enter image description
> here](https://images2.imagebam.com/7b/d9/3b/c22dd31338202372.jpg)

 
**Komanda Case**
E konverton tekstin < text> në madhësinë e dhënë < case>, e cila mund të jetë: lower, upper, capitalize, inverse, alternating.
>     java ds case <case> <text>
> ![enter image description
> here](https://images2.imagebam.com/2e/c9/a6/0b9c001338202369.jpg)
> ![enter image description
> here](https://images2.imagebam.com/8b/14/56/5042261338202374.jpg)
> ![enter image description
> here](https://images2.imagebam.com/ba/6c/67/6da21e1338202348.jpg)                    
> ![enter image description
> here](https://images2.imagebam.com/78/12/e1/4de12f1338202366.jpg)
> ![enter image description
> here](https://images2.imagebam.com/d7/2d/05/3e3dc91338202344.jpg)

Nenkomanda sentence konverton secilën shkronjë të fjalisë e cila gjendet pas këtyre karaktereve si (.), (?), (/), (!).                     

> ![enter image description
> here](https://images2.imagebam.com/d0/e9/a9/b6793b1338203463.jpg)

**Komanda Vigenere**
Vigenère Cipher është version më i avancuar i Kodit të Cezarit pasi që përdor më shumë se një zhvendosjesiçelës. Lexo më shumë [ketu](https://www.braingle.com/brainteasers/codes/vigenere.php).
Perbehet nga dy nenkomanda, encryp dhe decrypt
 
Nenkomanda encrypt 

>     ds vigenere encrypt <key> <plaintext> 
> ![enter image description
> here](https://images2.imagebam.com/64/6b/e8/a732071338202363.jpg)

Nenkomanda decrypt
>     ds vigenere encrypt <key> <cipertext> 
> ![enter image description
> here](https://images2.imagebam.com/be/de/18/1de4641338202359.jpg)

## License & Copyright
© Betim Thaçi, Çlirim Hodaj, Drinos Kukaj.  <br> University of Prishtina "Hasan Prishtina",  <br> Department: Computer Engineering.    <br>
Licensed under the [MIT License](LICENSE). 


