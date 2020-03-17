# datasecurity
Projekti nga lënda "Siguria e të dhënave"

Ky program eshte lehte i ekzekutueshem, varesishte nga kerkesat e juaja, ju duhet ti jepni argumentet dhe programi ploteson kerkesat e juaja.
Programi jone eshte i ndare ne tri komanda dhe secila komand ne disa nenkomanda.

Komanda e pare eshte e ndare ne dy nenkomanda encode dhe decode.

Komanda encode kthen secilen shkronje te alfabetit ne numer te poziten e saj ne alfabet, psh. shkronja 'a' kthehet ne numrin 1, shkronja 'b' kthehet ne numrin 2 e keshtu me rradhe.
Shembull  
java ds numerical encode "takohemi"
20 1 11 15 8 5 13 9

Komanda decode kthen shifrat e dhena ne numra perkates (ben te kunderten e komandes encode).
Shembull
java ds numerical decode "20 10 20"
tjt

Komanda e dyte case eshte e ndare ne pese nenkomanda te ndryshme, lowercase, uppercase,capitalize, inverse, alternating.

Komanda lowercase ben konvertimin e gjithe teksitit ne shkronja te vogla.
Shembull
java ds case lower "TakoheMI"
takohemi

Komanda uppercase ben konvertimin e gjithe tekstit ne shkronja te medha.
Shembull
java ds case upper "takohemi"
TAKOHEMI

Komanda capitalize konverton shkronjen e pare te secilen fjale ne shkronje te madhe.
Shembull
java ds case capitalize "takohemi neser"
Takohemi Neser

Komanda inverse, shkronjta e vogla i konverton ne te medha kurse shkronjat e medha ne shkronja te vogla.
Shembull
java ds case inverse "taKohemI"
TAkOHEMi

Komanda alternating konverton teksin ne njeren shkronje te vogel tjetren te madhe.
Shembull
java ds case alternating "takohemi"
tAkOhEmI
