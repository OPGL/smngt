FROM ghcr.io/graalvm/native-image-community:21 AS builder
WORKDIR /app
COPY . .
RUN ./mvnw package -Dpackaging=native-image

FROM debian:bookworm-slim
COPY --from=builder /app/target/smngt /usr/local/bin/smngt
RUN chmod +x /usr/local/bin/smngt
CMD ["/usr/local/bin/smngt"]
