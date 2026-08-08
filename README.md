readme
                         ┌────────────────────┐
                         │     Mobile/Web     │
                         └─────────┬──────────┘
                                   │
                                   ▼
                         ┌────────────────────┐
                         │   Gateway Service  │
                         │      :8080         │
                         └─────────┬──────────┘
                                   │
             ┌─────────────────────┼─────────────────────┐
             │                     │                     │
             ▼                     ▼                     ▼
       Auth Service          Customer Service       Account Service
          :8081                   :8082                 :8083
             │                     │                     │
             │                     │                     │
             └─────────────────────┼─────────────────────┘
                                   │
                         ┌─────────▼─────────┐
                         │      Kafka        │
                         │      :9092        │
                         └─────────┬─────────┘
                                   │
             ┌─────────────────────┼─────────────────────┐
             │                     │                     │
             ▼                     ▼                     ▼
       Transaction             Payment              Notification
         Service               Service                Service





             ┌──────────────────────────────────┐
             │         Platform Services        │
             │                                  │
             │ Config Service                   │
             │ Discovery Service                │
             │ Gateway Service                  │
             └──────────────────────────────────┘

             ┌──────────────────────────────────┐
             │        Infrastructure            │
             │                                  │
             │ PostgreSQL                       │
             │ Redis                            │
             │ Kafka                            │
             │ Zookeeper                        │
             │ Prometheus                       │
             │ Grafana                          │
             └──────────────────────────────────┘



