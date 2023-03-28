## propertiesファイルでリソースのファイル名管理をする例

[ResourceBundleTest](https://github.com/civic/file-resource-bundle/blob/main/src/test/java/ResourceBundleTest.java)

propertiesファイルで属性ごとに別のリソースファイルへのファイル名を保持
```properties
# mail.properties
body=/body.txt
```
```properties
# mail_ja.properties
body=/body_ja.txt
```

各リソースファイルで言語別のテキストデータを保持
```txt
# body.txt
Hello
World
```
```txt
# body_ja.txt
おはよう
こんにちは
```

ファイル名を取得してリソースファイルのテキストデータを読み込み
```java
ResourceBundle bundle = PropertyResourceBundle.getBundle("mail", Locale.ROOT);
String resourceName = bundle.getString("body");
String mailBody =
        new String(this.getClass().getResourceAsStream(resourceName).readAllBytes(), StandardCharsets.UTF_8);
assertEquals("Hello\nWorld\n", mailBody);

///////////////////////////////////////////

ResourceBundle bundle = PropertyResourceBundle.getBundle("mail", Locale.JAPANESE);
String resourceName = bundle.getString("body");
String mailBody =
        new String(this.getClass().getResourceAsStream(resourceName).readAllBytes(), StandardCharsets.UTF_8);
assertEquals("おはよう\nこんにちは\n", mailBody);


```

## YamlResourceBundleを使う例  

[YamlResourceBundleTest](https://github.com/civic/file-resource-bundle/blob/main/src/test/java/YamlResourceBundleTest.java)

外部ライブラリYamlResourceBundleを使用。

```yaml
# mail.yaml
mail.title: Mail Subject
mail.body: |
  Hello
  World
mail.foo: '1'
```

```yaml
# mail_ja.yaml
mail.title: メール件名
mail.body: |
  おはよう
  こんにちは
mail.foo: '2'
```

```java
ResourceBundle bundle = ResourceBundle.getBundle("yaml_resource_bundle.mail", Locale.ROOT,
        YamlResourceBundle.Control.INSTANCE);
assertEquals("Mail Subject", bundle.getString("mail.title"));
assertEquals("Hello\nWorld\n", bundle.getString("mail.body"));
assertEquals("1", bundle.getString("mail.foo"));

///////////////////////////////////////////

ResourceBundle bundle = ResourceBundle.getBundle("yaml_resource_bundle.mail", Locale.JAPANESE,
        YamlResourceBundle.Control.INSTANCE);
assertEquals("メール件名", bundle.getString("mail.title"));
assertEquals("おはよう\nこんにちは\n", bundle.getString("mail.body"));
assertEquals("2", bundle.getString("mail.foo"));

```
