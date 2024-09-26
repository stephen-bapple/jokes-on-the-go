DEFAULT_SUBJS="/C=US/ST=Colorado/L=Denver/O=stephen-bapple.github.io"
EMAIL_SUBJ="emailAddress=stephen.bapple@gmail.com"

CA_SUBJ="$DEFAULT_SUBJS/CN=CA/$EMAIL_SUBJ"
SERVER_SUBJ="$DEFAULT_SUBJS/CN=Jokes on the Go Server/$EMAIL_SUBJ"

# Cleanup
rm ./certs/*


# Generate self-signed CA and a private key to sign it
openssl req -x509 -newkey rsa:4096 -days 365 -nodes -keyout ./certs/ca-key.pem -out ./certs/ca-cert.pem -subj "$CA_SUBJ"

# Generate private key for the server and request for signing
openssl req -newkey rsa:4096 -nodes -keyout ./certs/server-key.pem -out ./certs/server-req.pem -subj "$SERVER_SUBJ"

# Use the CA to sign the server's cert
openssl x509 -req -in ./certs/server-req.pem -days 365 -CA ./certs/ca-cert.pem -CAkey ./certs/ca-key.pem -CAcreateserial -out ./certs/server-cert.pem -extfile server-ext.cnf

# Verify
openssl verify -CAfile ./certs/ca-cert.pem ./certs/server-cert.pem

# Copy CA to client's directory
mkdir -p ../client/src/main/resources/certs
cp ./certs/ca-cert.pem ../client/src/main/resources/certs
