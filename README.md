# Testes-Unitarios
App de Estudo de Testes unitários, consumindo dados da API Dummyjson + MVVM e Clean Archtecture

# 🚀 Android Architecture & Testing Showcase

Um projeto direto ao ponto que demonstra como estruturar um aplicativo Android nativo utilizando o que há de mais maduro no mercado: **Clean Architecture**, **MVVM** e uma arquitetura de **Testes Unitários sem frameworks pesados**.

---

## ⚡ O que este projeto resolve?

* **Desacoplamento Total:** A regra de negócio não sabe (e não se importa) que a API usa Retrofit.
* **Testes Instantâneos:** Zero dependência de internet ou emulador para rodar os testes.
* **Ciclo de Vida Protegido:** ViewModel blindada contra rotações de tela e vazamentos de memória.

---

## 🧠 Arquitetura Visual

O projeto divide a produção (`main`) e os testes (`test`) de forma perfeitamente espelhada. Bateu o olho, achou:

| Camada | 📦 Produção (`main`) | 🧪 Testes (`test`) | Papel Estratégico |
| --- | --- | --- | --- |
| **Data** | `DummyAPIService`, `RetrofitService` | `DummyAPIFake`, `UserDTOTestHelper` | Infraestrutura e consumo de rede bruto. |
| **Domain** | `Usuario`, `GetUsuarioUseCase` | `UsuarioRepositoryTestFake` | O coração do app. Regras de negócio puras. |
| **Presentation** | `MainActivity`, `UsuarioViewModel` | `UsuarioUseCaseFake`, `UsuarioViewModelTest` | Estado da tela e interação com o usuário. |

---

## 🧪 A Estratégia dos Testes (O Diferencial)

Em vez de inflar o projeto com Mockito ou MockK, este projeto adota **Fakes Manuais** (dublês de teste customizados).

* **Por que isso importa?** Os testes rodam na velocidade da luz (milissegundos) porque usam objetos em memória estruturados, simulando cenários reais de sucesso e erro.
* **Teste de UI síncrono:** Utiliza o helper `LiveDataTestUtil.kt` para interceptar os estados da ViewModel de forma imediata e limpa.

---

## 🛠️ Stack Tecnológica

* **Language:** Kotlin nativo
* **Network:** Retrofit (consumo síncrono da DummyAPI)
* **Engine de Testes:** JUnit

---

## 🏃‍♂️ Executando em 2 Passos

1. **Clone e Abra:** Abra o diretório no seu Android Studio.
2. **Rode os Testes:** Clique com o botão direito na pasta `src/test/java` e selecione **Run 'Tests in...'** para ver a mágica dos Fakes em ação.

---

<img width="350" height="613" alt="image" src="https://github.com/user-attachments/assets/2dfcb1f0-14b3-4291-aa46-afc84d5bf026" />
<img width="350" height="613" alt="image" src="https://github.com/user-attachments/assets/d818ed6b-cc6a-405c-9a3a-2637084ecbea" />
<img width="350" height="613" alt="image" src="https://github.com/user-attachments/assets/f7611405-5c43-490a-9143-bd1afa870566" />



