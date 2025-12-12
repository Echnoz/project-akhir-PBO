Kalau tidak bisa di-run langsung, lakukan langkah berikut:

Cara 1:
- run di terminal dengan command berikut: java -cp out tugofwar.Main

atau

cara 2:
- compile di terminal dengan command berikut: javac -d out $(Get-ChildItem -Recurse -Filter *.java | %{$_.FullName})
- lalu run di terminal dengan command berikut: java -cp out tugofwar.Main