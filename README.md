# RSA
## Relevance
The RSA algorithm is a cryptographic algorithm that is used for specific security services or purposes. It widely used to secure sensitive data, particularly when it is being sent over an insecure network such as the internet. In RSA cryptograpthy, both keys can encryp and decrypt data. Thus, it provides a method to assure the confidentiality, integrity, authenticity and non-repudation of electronic communications and data storage. All of that makes it one of the most popular cryptographic algorithms.
Many protocols like secure shell, OpenPGP, S/MIME, and SSL/TLS rely on RSA for encryption and digital signature functions. It is also used in software programs - browsers are an obvious example, as they need to establish a secure connection over an insecure network, like the internet, or validate a digital signature. RSA signature verification is one of the most commonly performed operations in network-connected systems.

## Concept
RSA (Rivest-Shamir-Adleman) asymetric cryptography algorithm is based on the practical complexity of factorization of large numbers. The public and private key generation algorithm is the most complex part of RSA cryptography. Two large prime numbers, **p** and **q**, are generated. A modulus, **n**, is calculated by multiplying **p** and **q**. This number is used by both the public and private keys and provides the link between them. Its length, usually expressed in bits, is called the key length. The public key consists of the modulus **n** and a public exponent, **e**, which is normally set at 65537, as it's a prime number that is not too large. The **e** figure doesn't have to be a secretly selected prime number, as the public key is shared with everyone. The private key consists of the modulus **n** and the private exponent **d**, which is calculated using the Extended Euclidean algorithm to find the multiplicative inverse with respect to the totient of **n**.

## Program
The program works as an interactive form. It allows users to encrypt and decrypt text data using specified keys.
RSA can encrypt numbers up to the module that is part of the key. Modules with a length of 1024, 2048 and even 4096 bits are used nowdays. This realization of RSA use 64-bit keys, but it is enough for clarity. There are such commands:
  * e <public exp> <mod> <file in> <file out>  - to encrypt file
  * d <private exp> <mod> <file in> <file out> - to decrypt file
  * g <prime1> <prime2> - to generate key pair from primes
  * G - to generate key pair from default primes
  * h - show help note
  * q - to exit
  
  *Note: primes must be more than 1000 to make RSA more safer*
  
  


The program is implemented in an interactive form, the list of commands can be called with the **h** command.
Encryption and decryption are performed by ***encrypt*** and ***decrypt*** functions in accordance.
