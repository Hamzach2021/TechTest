# StarlingTechTest
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
