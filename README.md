# StarlingTechTest Hamza Tariq
You will have to set a system variable called Authorization, and can invoke the roundup using the below URL, http://localhost:8080/transactions/f7bc1bbd-e015-4a2d-bf5f-0ead8ec58307/f7bc03eb-ea9b-4f5a-8dea-cd33f8643b6b

Set the Authorization to this : eyJhbGciOiJQUzI1NiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAA_21Ty5KjMAz8lSnOoyliHgm5zW1_YD9AyHLiGrAp22R2amv_fQ2GEFLJiW5JrZal_M2099k5w0GD5N5--ICu0-bSovn6INtn75kf25ihji3FXw65yk9QCiUAkRugY6PqVpyoaeuYzH-G7Hw4Fk1-qIry8J5pDDNxasSpmQgksqMJv2wn2f3WctHmOioWolZQUlvCqcorkAdxPDRCVFK0UTvYLzapomhPlWxygoZEdCOxBiwqBSxkg3VRVLFVrIhjfRKx91ufuqYaqI3qJcVBWoECpCyPpchlqZSYBiY78PQoySlcZ6tgsOezY5RvT4HwMzwFtGQTtNLs9nynfdgxC5DSRZNnljrcQYqEgHTt-Z654W-nA7_hGK7WaR9XBtpIfdNyxC4lt9ihocUaoZNA1gRnu9RoYpaYNUq7HoO2BqwCNRq5GKDRB9uvc3CPeqnu0UgMfJbccfSxwjmt54AR4ZkinIIrnisH_GFeQwksIglsSaB7vCyaKbZ9QnBoPNLk-U5DZylOv2knAuz0DM_sUuWs0t3aKvXeUXOWY2I9hB3w-1Dah8dbXIWHi9187Lhl1B036zwyaTgVn_2FxBZ8obUFkyhdWY4dS4hjb2fkOYQ44DgscMD1TOL_P15RPCbr5EP7Pbv23bMv6sF-mzsfeDIA5G_P1CBVoh53Oq_iecnZv_8r3RktsgQAAA.ZNOtnyUYFF1wPmxULNv8GFlDqzbqjSs-z_JyEULKo_eo8Cgl4WtHdosq7yHRYMvESN4NbcxkheoGRpC5Nu5ogn4QJzDDFsRT93Zehk19o-ZCLc0Bb7QZ68tV8R0BtaImKSHGVAzxPY9yiUeD3MiarEwvvJR4v0JmMIy_ngGqn9Tpk6QMU8lWYcQtxEIqF3oGx2rw5lBD0bh-ntoND1_vwSF3f-PWGcRoiIfVPvsjIHHw7XYzyXT5nht4IOH7-H9m9R91FMTZuYCEpzkuWsj6LoiU-izeG5uALV_JfswsBORCTNSCo5WpeCeOYklOdOQg6s56oxgrN_l_xN_C8UpoHYX5Df1wgAVVg9TSNb0V9HgWV8cNK3Jrxpb5RQl0gSZ00K7veDX9xio96ot-WwM2bo9ef6c8kSZ1hz57JXSjLho7Ym0-0KO9c2xkPMv9gDvS4vG_0Fg0KrIGxh2OVyLCcx51PJCWEI6DBhM_C2pp0X5q2o6Y3p-MZ02Ntqpx_HikkUHVD2bXkL3_1IA8L1ijkAKVJsOgNeFVQnFUils1sD0bUV--gaEE6Vi2EHKlHIvY_ngB9DGDbEiNNdppO8zGPpXELfT4orwNOBOLHMgSdYOZTXi3Q895up-dsfAeOoGQaqhAaplryFVCmlksqBpYW6v98TXxWj2j6gqZ-PRAgdw

This could've been done in a very safe way through yaml file.


 The round-up feature was implemented using RestTemplate because it was quick and familiar. However, the recommended approach in Spring Boot 3+ is to use RestClient, which provides:
 
Fluent API → More readable and flexible request building.
Easier Customization → Supports interceptors and error handling in a clean way.
While RestTemplate is still widely used, it's been feature completed in favor of RestClient, making RestClient better long-term choice.

For data transfer objects (DTOs), I used Java Records instead of traditional POJOs with Getters/Setters because:

Immutability → Prevents unintended modifications.
Concise Syntax → Less boilerplate (no need for explicit constructors, getters, equals(), hashCode(), etc.).
Better Performance → Records are optimized at the JVM level.
Since my DTOs were only for data holding, records made perfect sense. If I needed custom logic or mutability, a traditional POJO would be a better fit.
I kept things simple to get this working fast, but I'm always open to discussions on improving this approach.




