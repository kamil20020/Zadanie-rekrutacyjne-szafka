# Zadanie rekrutacyjne - szafka z plikami

## Cel
Zadanie rekrutacyjne polega na analizie otrzymanego kodu i zaimplementowanie brakujących elementów. Otrzymany kod jest 
napisany w języku `Java` i również w tym języku należy zaimplementować brakujący kod.


## Problematyka
Problematyka jest związana z modelowaniem szafki zawierającej foldery z plikami i operacjami wykonywanymi na tych folderach. Dla 
ułatwienia zrozumienia zadania dodałem od siebie kontekst w postaci możliwego zastosowania problematyki. Przykładem 
zastosowania jest szafka w przychodni zawierająca dokumenty pacjentów, czyli pliki. Każdy pacjent ma własną teczkę na dokumenty (inaczej folder),
które go dotyczą. Jednak w folderze danego pacjenta mogą być jeszcze inne foldery np. członków rodziny. Dodatkowo foldery mogą być 
różnych rozmiarów np. mały, średni i duży.

## Zadanie
Podstawowym zadaniem jest implementacja metod operujących na folderach. Należy zaimplementować pobieranie folderu po nazwie, 
pobieranie folderów o danym rozmiarze oraz zliczanie wszystkich folderów.

Dołożyłem od siebie przeprowadzenie testów, aby mieć pewność, iż pomyślnie zaimplementowałem aplikację. Z tego względu 
wygodne będzie użycie narzędzia do zarządzania zależnościami i budowania. Testy będą napisane klasycznie w `JUnit5`, a 
narzędzie do zarządzania projektem z jakiego skorzystam, to `Maven`.

## Rezultat
Udało się zrealizować zadanie, co udowodniono poprzez pomyślne przeprowadzenie testów. Stworzono ogólnie 13 testów. Aby 
móc napisać testy programu, zaimplementowano wcześniej standardowe i multi foldery oraz dodano kilka metod i konstruktorów,
w celu wygodniejszego zbudowania zagnieżdżonej struktury folderów.

