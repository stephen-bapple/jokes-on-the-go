DEFAULT_SUBJS="/C=US/ST=Colorado/L=Denver/O=stephen-bapple.github.io"
EMAIL_SUBJ="emailAddress=stephen.bapple@gmail.com"

CA_SUBJ="$DEFAULT_SUBJS/CN=CA/$EMAIL_SUBJ"
SERVER_SUBJ="$DEFAULT_SUBJS/CN=Jokes on the Go Server/$EMAIL_SUBJ"

# Cleanup
rm *.pem

# Generate self-signed CA and a private key to sign it
openssl req -x509 -newkey rsa:4096 -days 365 -nodes -keyout ca-key.pem -out ca-cert.pem -subj "$CA_SUBJ"

# Generate private key for the server and request for signing
openssl req -newkey rsa:4096 -nodes -keyout server-key.pem -out server-req.pem -subj "$SERVER_SUBJ"

# Use the CA to sign the server's cert
openssl x509 -req -in server-req.pem -days 30 -CA ca-cert.pem -CAkey ca-key.pem -CAcreateserial -out server-cert.pem

# Verify
openssl verify -CAfile ca-cert.pem server-cert.pem

# Copy CA to client's directory
cp ca-cert.pem ../../client/src/main/resources/certs
