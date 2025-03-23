
# Final Projesi - DefineX Java Spring Boot Bootcamp

Bu proje, DefineX Java Spring Boot Bootcamp'inin final projesidir. Mikroservis mimarisi uygulanarak geliştirilmiştir.

Website: [nbenlioglu.dev](https://www.nbenlioglu.dev/)<br>
LinkedIn: [Nikolay Benlioglu](https://www.linkedin.com/in/nikolay-benlioglu/)<br>
GitHub: [nbenliogludev](https://github.com/nbenliogludev)<br>
Email: [nikbenlioglu@gmail.com](mailto:nikbenlioglu@gmail.com)

## Kısaca Bazı Özellikler

- Her temel servisin kendi veritabanı bulunuyor.
- RabbitMQ ile asenkron mesajlaşma sağlandı.
- Loglar için MongoDB kullanılıyor.
- Eureka service discovery yapısı hazırlandı.
- Next.js ile oluşturulmuş basit bir önyüze sahip.
- Postman üzerinden denenebilir.

## Postman ile deneyin
API adreslerini Postman ile deneyebilirsiniz: [**Postman API** 🚀](https://documenter.getpostman.com/view/5602393/2sA3kVj1Xz)

## Mikroservisler

Aşağıda projeye ait mikroservislerin listesi bulunmaktadır.<br>
<br>📦 User Authentication Service
<br>📦 File Storage Service
<br>📦 Task Management Service
<br>🐝 Log Aggregation Service
<br>⛩️ API Gateway
<br>🌐 Eureka Service Discovery


## Proje Şeması

![Proje Diyagramı](images/fmss-project-diagram.png)

## AuthenticationService

AuthenticationService, JWT kullanarak kullanıcı kimlik doğrulama işlemlerini yönetir. Kullanıcı kayıt, giriş, ve çıkış işlemlerini sağlar.

### API Adresleri

| Method | Adres                      | Açıklama                                |
|--------|----------------------------|-----------------------------------------|
| `POST` | `api/auth/v1/register`     | Yeni bir kullanıcı kaydı oluşturur      |
| `POST` | `api/auth/v1/authenticate` | Kullanıcı kimlik doğrulama işlemi yapar |


# Log Toplama Servisi - [Log Aggregation Service](log-aggregation-service)

Log toplama servisi, diğer mikroservislerden üretilen hata ve bilgi loglarını toplar ve MongoDB veritabanına kaydeder.
Bunlara erişmek için bir API sunar. MongoDB veritabanınızı yönetmek için projede Mongo Express de bulunuyor.

### API Adresleri

| Method | Adres                                      | Açıklama              |
|--------|--------------------------------------------|-----------------------|
| `GET`  | `log-aggregation-service/api/v1/info-logs` | Bilgi loglarını getir |
| `GET`  | `log-aggregation-service/api/v1/error-logs`| Hata loglarını getir  |

# API Gateway - [API Gateway](api-gateway)

API Gateway, diğer mikroservislerin API'lerini tek bir noktadan erişilebilir hale getirir. Ayrıca servislerin bulunduğu adresleri Eureka üzerinden alır.

# Eureka Sunucusu - [Eureka Server](eureka-server)

Eureka sunucusu, diğer mikroservislerin kayıt olduğu ve bulunduğu adresleri tutan bir servistir. API Gateway, Eureka üzerinden diğer servislerin adreslerini alır.

<br>

## DefineX Java Spring Boot Bootcamp

Website: [nbenlioglu.dev](https://www.nbenlioglu.dev/)<br>
LinkedIn: [Nikolay Benlioglu](https://www.linkedin.com/in/nikolay-benlioglu/)<br>
GitHub: [nbenliogludev](https://github.com/nbenliogludev)<br>
Email: [nikbenlioglu@gmail.com](mailto:nikbenlioglu@gmail.com)
