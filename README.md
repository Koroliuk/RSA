# RSA
RSA (Rivest-Shamir-Adleman) is one of the public-key ctyptosystems and is widely used for secure data transmission. The RSA asymetric cryptography algorithm is based on the practical complexity of factorization of large numbers, which makes is one of the most popular cryptographic algorithms today.

RSA can encrypt numbers up to the module that is part of the key. Modules with a length of 1024, 2048 and even 4096 bits are used nowdays. This realization of RSA use 64-bit keys, but it is enough for clarity. Encryption and decryption are performed by ***encrypt*** and ***decrypt*** functions in accordance. The modular exponentiation algorithm is used for that. Also the program can generate keys by using defualt primes or primes that entered by the user. The extended Euсlidean algorithm is used for efficiently computing the modular multiplicative inverse in the ring.

The program is implemented in an interactive form, the list of commands can be called with the **h** command.
