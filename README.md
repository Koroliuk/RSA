# RSA
## Relevance
The RSA algorithm is a cryptographic algorithm that is used for specific security services or purposes. It widely used to secure sensitive data, particularly when it is being sent over an insecure network such as the internet. In RSA cryptography, both keys can encrypt and decrypt data. Thus, it provides a method to assure the confidentiality, integrity, authenticity, and non-repudation of electronic communications and data storage. All of that makes it one of the most popular cryptographic algorithms.
Many protocols like secure shell, OpenPGP, S/MIME, and SSL/TLS rely on RSA for encryption and digital signature functions. It is also used in software programs - browsers are an obvious example, as they need to establish a secure connection over an insecure network, like the internet, or validate a digital signature. RSA signature verification is one of the most commonly performed operations in network-connected systems.

## Concept
RSA (Rivest-Shamir-Adleman) asymmetric cryptography algorithm is based on the practical complexity of the factorization of large numbers. The public and private key generation algorithm is the most complex part of RSA cryptography. Two large prime numbers, **p** and **q**, are generated. A modulus, **n**, is calculated by multiplying **p** and **q**. This number is used by both the public and private keys and provides the link between them. Its length, usually expressed in bits, is called the key length. The public key consists of the modulus **n** and a public exponent, **e**, which is normally set at 65537, as it's a prime number that is not too large. The **e** figure doesn't have to be a secretly selected prime number, as the public key is shared with everyone. The private key consists of the modulus **n** and the private exponent **d**, which is calculated using the Extended Euclidean algorithm to find the multiplicative inverse in the module ring of **n**.

## Program
The program works as an interactive form. It allows users to encrypt and decrypt text data using specified keys.
RSA can encrypt numbers up to the module that is part of the key. Modules with a length of 1024, 2048 and even 4096 bits are used nowdays. This realization of RSA use 64-bit keys, but it is enough for clarity. There are such commands:
  * e <public exp> <mod> <file in> <file out>  - to encrypt file
  * d <private exp> <mod> <file in> <file out> - to decrypt file
  * g <prime1> <prime2> - to generate key pair from primes
  * G - to generate key pair from default primes
  * h - show a list of commands
  * q - to exit
  
  *Note: primes must be more than 1000 to make RSA more safer*
  
The program is written in Java and build by Maven. Is consists of 4 classes. The key structure is implemented in  **Key.java** file. The **GenerateKeys.java** file provides key generation. Encryption and decryption are performed by encrypt and decrypt functions in accordance, which located in **AsymmetricCryptography.java**. User interaction implemented in **App.java**. Also, the program is provided with unit tests for each module. Moreover, there is a system test (it test every program command) in **AppTest.java**, which tests the correct combining of every puzzle of the program. *(Junit4 has used for that)*
  
All code has been verified by SonarLint. All dependencies are listed in **pom.xml** flie.
  
## Help
Ask questions at https://t.me/Koroliuk_Yaroslav and post issues on github.
 
## LicenseGNU
Don\`t forget about licence. This program is GNU General Public licensed.
