# Contextual-Cards
An example showing how to display different view types and their attributes in a list view using a JSON response.

## Usage
Provide the card structure in Json using the given schema and see the magic.

```
"card_groups": [
    {
      "id": 31,
      "name": "UPI Register HCG",
      "design_type": "HC6",
      "cards": [
        {
          "name": "UPI Register card",
          "title": "Setup your UPI ID",
          "formatted_title": {
            "text": "Setup your {}",
            "entities": [
              {
                "text": "UPI ID",
                "color": "#FF0000"
              }
            ]
          },
          "description": "Register now and start UPI payments",
          "formatted_description": {
            "text": "Register now and start {}",
            "entities": [
              {
                "text": "UPI payments",
                "color": "#00FF00"
              }
            ]
          },
          "icon": {
            "image_type": "ext",
            "image_url": "https://d1nhio0ox7pgb.cloudfront.net/_img/o_collection_png/green_dark_grey/128x128/plain/shape_square.png"
          },
          "url": "https://youtube.com/"
        }
      ],
      "is_scrollable": false
    }
```


<img src="images/result1.PNG" alt="" width="80%">

### Built With

<img src="https://miro.medium.com/max/480/1*oNM0JVqivoi3lVPF6ygp9Q.png" alt="" width="120" height="64">

* [Kotlin](https://kotlinlang.org/)
