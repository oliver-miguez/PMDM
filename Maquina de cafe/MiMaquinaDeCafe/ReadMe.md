``` mermaid 
stateDiagram-v2
    [*] --> Idle
    Idle --> CalentarAgua
    CalentarAgua --> SoltarLeche
    SoltarLeche --> SoltarAzucar
    SoltarAzucar --> SoltarCafe
    SoltarCafe --> PreparandoExtra: extra = "canela"
    PreparandoExtra --> SoltarExtra
    SoltarExtra --> Resetear    PreparandoExtra --> Resetear
    Resetear --> Idle
    Idle --> Error
    
```