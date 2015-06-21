# Playfair_Chiffre
Just a small simple playfair java program.

# Run the jar-File
Run the jar-File in your command line. Navigate to the directory where the file is stored.
Type in command line to execute the program:  <b>java -jar playfairchiffre.jar "yourkey" "your text to encode"</b> then press "Enter"

Now your text will be encoded and decoded. Additionally you will see the playfair-matrix with your given key to analyse how the playfair-chifre work. <br>



<code>




&nbsp;&nbsp;  0 1 2 3 4  

0   S U R P I <br>
1   E A B C D <br>
2   F G H K L <br>
3   M N O Q T <br>
4   V W X Y Z <br>
________________<br>


____________Enccode_____________<br>

Original text: ILOVEYOU<br>
Prepared text: ILOVEYOU<br>
Bigrams: IL OV EY OU <br>
I+L<br>
I found at: Row'0' and Column'4'<br>
L found at: Row'2' and Column'4'<br>
O+V<br>
O found at: Row'3' and Column'2'<br>
V found at: Row'4' and Column'0'<br>
E+Y<br>
E found at: Row'1' and Column'0'<br>
Y found at: Row'4' and Column'3'<br>
O+U<br>
U found at: Row'0' and Column'1'<br>
O found at: Row'3' and Column'2'<br>


____________Decode_____________<br>

Original text: DTMXCVNR<br>
Prepared text: DTMXCVNR<br>
Bigrams: DT MX CV NR <br>
D+T<br>
D found at: Row'1' and Column'4'<br>
T found at: Row'3' and Column'4'<br>
M+X
M found at: Row'3' and Column'0'<br>
X found at: Row'4' and Column'2'<br>
C+V<br>
C found at: Row'1' and Column'3'<br>
V found at: Row'4' and Column'0'<br>
N+R<br>
R found at: Row'0' and Column'2'<br>
N found at: Row'3' and Column'1'<br>
<br>
<br>
____________Outputs_____________<br>
<br>
Encoded text: DTMXCVNR<br>
Decoded text: ILOVEYOU<br>



</code>








Hope you enjoy the program.
