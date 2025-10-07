``` mermaid 
stateDiagram-v2
    [*] --> Idle
    Idle --> CalentarAgua
    CalentarAgua --> SoltarLeche: calentando Agua
    SoltarLeche --> SoltarAzucar: calentando Leche
    SoltarAzucar --> SoltarCafe: soltar azucar
    SoltarCafe --> PreparandoExtra: extra = "canela"
    PreparandoExtra --> SoltarExtra
    SoltarExtra --> Resetear    PreparandoExtra --> Resetear
    Resetear --> Idle
    Idle --> Error
    
```