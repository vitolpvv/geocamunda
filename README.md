# geocamunda
Пример работы с Camunda BPM

Проект является клиентом сервиса DaDataProxy. Предназначен для разворачивания на платформе Camunda BPM.
Перед сборкой проекта необходимо указать актуальные адрес, порт и путь запроса сервиса DaDataProxy в файле /source/src/main/resources/dadataproxy.properties.

Для сборки проекта выполнить "mvn install" в папке source. В итоге в папке source/target будет собран war-архив (geocamunda.war).

Инструкция по установке платформы Camunda - https://docs.camunda.org/get-started/java-process-app/install/

Инструкция по разворачиванию сервиса - https://docs.camunda.org/get-started/java-process-app/install/

В итоге на платформе появится процесс Address Geo.
Процесс состоит из трех задач:
1. Enter Address - пользователь вводит адрес для поиска.
2. Process Address Geo - отправказ запроса сервису DaDataProxy и обработка результата.
3. Show Geo - отображение результата в форме.

В разделе TaskList можно запустить экземпляр этого процесса.
В списке задач появится задача "Enter Address" с формой для ввода адреса.
После заполнения формы выполняется задача "Process Addres Geo".
Затем в форму выводится результат запроса (задача "Show Geo").

BPMN-диаграмма - source/src/main/resources/address_geo.bpmn
