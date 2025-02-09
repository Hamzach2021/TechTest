# StarlingTechTest Hamza Tariq
You will have to set a system variable for access token and name it Authorization, and you can invoke the roundup using the below URL, http://localhost:8080/transactions/f7bc1bbd-e015-4a2d-bf5f-0ead8ec58307/f7bc03eb-ea9b-4f5a-8dea-cd33f8643b6b

Set the Authorization System Variable to this : eyJhbGciOiJQUzI1NiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAA_21Ty27jMAz8lcLnsnAUxY_cetsf2A-gKSoRakuGJKdbLPbfV47suA6ak2eGHJIi87cwIRTnAkcDigf3FiL63thLh_bjjdxQvBZh6lKErjtKvxJKXTYghRaAyC1Q3eqqEw21XZWC-c9YnA_1sT00TSPL18JgXIhSyJlAIjfZ-Mv1iv1voxZvrpLjUVQaJHUSmlN5AnUQ9aEV4qREl7yj-2CbM2SlysOpqwDr9gRSooBGHGsQ1Eqlj8dWymPKSGO9E3EIW52qogqoS-6S0iCdSKlKyVqKUkmtxTwwuZHnR8mdwvXeKlgc-OwZ1cuTEL_GJ8EottFow37P9ybEHbMApXxq8szKxAfISoxI14EfkRv-9CbyC07x6rwJaWVgrDI3oybsc3CHPVpaWiP0CsjZ6F2fC83MojmrjR8wGmfBadCTVUsDNIXohnUOHtAs2QNahZHPintOfazwHjZwxITwTAnO4orvmSN-Ma9SBotJBlsQmAEvi2fWtk-IHm1Amnt-0NA7StNv3pkANz_DM7tkeadNv5bKtXfUPcozsRnjDoS9lPcR8JZWEeDitj523DLqjrv7fGfycDo9-w8Wm_iD1yZmU7qymnpWkMbezihwjGnAaVzgiOuZpP9_uqJ0TM6rb-X37Fp3z_6QD-7TPvjIcwNA4fZMjUpn6vtO76t4XnLx7z_J0LW3sgQAAA.X8mKz96qcfCye41uGQFddvrdfTz5bIhizCmSGAHhPOlnyCXD2JXnkEa1qJRjZVKTD81hWgm40bKHU3T8DqSanW5w2COTzypJg1_twiagOxyIglAIFRenGRVTL5nNmU0Yp-HMYqv3K80bUhJhFscR49miGr2zn7U_aXgCkCh5VwNsSZLZajfCKPLB7d0Jv7JCsuR1MpudPZxdLt-KE8v0HRW-I-F4RavXtriCZLYZhJJaR5A2ea5saP9bSH4g3LZqymMJGxK-298RvTEJ-532eYOl6G-gihsRFoiNzh1XXwELJMV6l_4BZcP4-rK-LU_VQ0RV2X8bLLmUKCxtI3U5RbCUKoTG27oFwZPda-k81DkqBgII0AP3hlqkRr8ZzJ8X23r09B9Hamtfv5wIaUJK5PFkGeCdgAL_ohjwpYQzXZBbzvuTuBolT0JCWjBZ3rOpRJzxn1_E4I5e9WO2tRfP97PV0F3fQ9elMPgje70NfW5jsGApMI7f5OQsjHitMVsn7fasB_3uJgQZVGPyJ-nf-9hYs_501WKR12i0x46-IWbjVrBa2RetWK9FC5CuFf5H-TYW_eoo32wjnQsNy1RgBIHKKjswmyhk_sDxLtRVw54UB-35GZ7KDcerBrZDsYUxHH3ubmtScFRlrg_6V_MlE0vg7EU8TKkq9-vAQArKZdI

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




