
# **Projekti në lëndën 'Siguria e të dhënave'**



## Qëllimi
Qëllimi i këtij projekti është që të krijohet një aplikacion lehtë i ekzekutueshëm dhe lehtë i përdorshëm me qëllim të ekriptimit dhe dekriptimit të fjalive të ndryshme me algoritme të caktuara.

## Ekzekutimi dhe kompajllimi i programit

 - Që programi jonë  të  ekzekutohet duhet që të gjithë filet të jenë në një  folder të njejtë.
 - Programi jonë mund të ekzekutohet nga Command Line ose Git Bash. Ne do të tregojm si ekzekutohet sipas Git Bash, krejtësisht njejtë shkon edhe me CommandLine.
 - Fillimisht duhet në Git Bash te çasemi në folderin ku e kemi projektin, në shembullin më poshtë shihet qartë se si bëhet kjo.

> ![enter image description
> here](https://images2.imagebam.com/df/39/84/e892f11338519796.jpg)

 - Me anë të komandës `javac` ne bëjmë kompajllimin e programit tonë të emëruar ds.java. 

> ![enter image description
> here](https://images2.imagebam.com/66/0a/e7/d0e7c71338519799.jpg)

 - Pas kësaj përmes komandave `java ds` dhe argumenteve bëjmë thirrjen e kërkesave që ploteson programi jonë. 

> ![enter image description
> here](https://images2.imagebam.com/00/bc/ad/bfa63b1338519801.jpg)

Për të parë se qfarë kërkesa plotëson programi jonë klikoni shikojeni përmbajtjen.

## Permbajtja
Progami jonë permbanë tri komanda dhe secila komand është e ndarë në disa nënkomanda

Komanda e parë është e ndarë në dy nënkomanda:
 - Encode
 - Decode

Komanda encode kthen secilen shkronjë të alfabetit në numer të pozites se saj në alfabet, psh. shkronja 'a' kthehet në numrin 1, shkronja 'b' kthehet në numrin 2 e keshtu me rradhë. 

> ![enter image description
> here](https://images2.imagebam.com/49/78/b1/6b52d11338202361.jpg)

                                             

Gjithashtu te enkodimi kemi mundësi të zgjedhim opsionin "--separator" në mënyrë që kur të kodohet fjalia, hapësirat në fjali të zëvendësohen me karakterin që dëshirojmë.

> ![enter image description
> here](https://images2.imagebam.com/7b/d9/3b/c22dd31338202372.jpg)

                                             

Komanda decode kthen shifrat e dhëna në numra perkatës (bën të kundërtën e komandës encode). 

    

> ![enter image description
> here](https://images2.imagebam.com/07/09/7a/386c761338202356.jpg)

                                             

Komanda e dyte case është e ndarë në gjashtë nënkomanda të ndryshme:
 - Lowercase
 - Uppercase
 - Capitalize
 - Inverse
 - Alternating
 - Sentence

Komanda lowercase bën konvertimin e gjithë teksitit në shkronja të vogla.                                                               

> ![enter image description
> here](https://images2.imagebam.com/2e/c9/a6/0b9c001338202369.jpg)

Komanda uppercase bën konvertimin e gjithë tekstit në shkronja të mëdha.                                                                 

> ![enter image description
> here](https://images2.imagebam.com/8b/14/56/5042261338202374.jpg)

Komanda capitalize konverton shkronjën e parë të secilës fjalë në shkronjë të madhe.                                                     

> ![enter image description
> here](https://images2.imagebam.com/ba/6c/67/6da21e1338202348.jpg)

Komanda inverse, shkronjtat e vogla i konverton në shkronja të mëdha kurse shkronjat e medha në shkronja të vogla.                       

> ![enter image description
> here](https://images2.imagebam.com/78/12/e1/4de12f1338202366.jpg)

Komanda alternating konverton teksin në njerën shkronjë të vogël tjetrën të madhe.                                                       

> ![enter image description
> here](https://images2.imagebam.com/d7/2d/05/3e3dc91338202344.jpg)

Komanda sentence konverton secilën shkronjë të fjalisë e cila gjendet pas këtyre karaktereve si (.), (?), (/), (!).                     

> ![enter image description
> here](https://images2.imagebam.com/d0/e9/a9/b6793b1338203463.jpg)

Komanda e tretë ka të bëjë me algoritmin Vigenere për enkripim dhe dekriptim, gjithashtu edhe kjo komand ndahet në dy nënkomanda
 - Encrypt
 - Decrypt

Vigenere Cipher është një metodë e kriptimit të tekstit alfabetik. Përdor një formë të thjeshtë të zëvëndësimit polialfabetik.
Lexo me shumë për Vigenere [këtu] (https://www.braingle.com/brainteasers/codes/vigenere.php) </n>
Tabela përbëhet nga alfabete të shkruara 26 herë në rreshta të ndryshëm, secili alfabet në mënyrë ciklike zhvendoset në të majtë në krahasim me alfabetin e mëparshëm, që korrespondon me 26 shifrat e mundshme të Cezarit. </n>
Tabela e algoritmin Vigenere per enkriptim dhe dekriptim.

> ![enter image description
> here](https://media.springernature.com/original/springer-static/image/chp:10.1007/978-3-030-16681-6_4/MediaObjects/477735_1_En_4_Fig2_HTML.png)
 
Komanda encrypt bënë enkriptimin e një plaintexti permes një çelësi dhe kthen ciphertextin.

> ![enter image description
> here](https://images2.imagebam.com/64/6b/e8/a732071338202363.jpg)

Komanda decrypt bënë dekriptimin e një ciphertexti përmes një çelësi dhe kthen plaintextin.

> ![enter image description
> here](https://images2.imagebam.com/be/de/18/1de4641338202359.jpg)

Gjithashtu qoftëse ju gaboni në përdorim të programit tonë si psh jepni argumente jo valide, programi jone ju lajmeron dhe ju mund ti shenoni ato drejtë.

> ![enter image description
> here](https://images2.imagebam.com/ae/6c/9f/3202d31338202365.jpg)

## License & Copyright
© Betim Thaçi, Çlirim Hodaj, Drinos Kukaj.  </n>
University of Prishtina "Hasan Prishtina",  </n>
Department: Computer Engineering.    </n>
Licensed under the [MIT License](LICENSE). 
