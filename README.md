# Welcome to the Water Watcher GitHub!
Water Watcher is the backend for a hobby project of mine created with the goal of helping me efficiently water my plants. At the moment, the project is just set up to monitor my basil plant but I would like to expand it to many more of my plants in the future!

Head over to the project's website [here](https://www.florafeed.jackford.tech/) to watch the whole thing in action and read about end-to-end implementation details, or read on to learn more about the details of this specific repo!

## How does Water Watcher work?
Water Watcher is a Java/Spring Boot RESTful web service manually hosted on a DigitalOcean droplet, with endpoints exposed for sending and receiving soil moisture data. It is designed as a microservice, so you can expect the domain of functionality to remain about the same throughout the future.

Currently, the only supply of data to this microservice comes from my Raspberry PI that is collecting moisture data through a capacitive moisture sensor (you can learn more about this on the above linked website) before sending the data to this microservice via a POST request to the /moisturereadings endpoint. Water Watcher then authenticates the request against a provided auth token, persisting the moisture readings in a MySQL database. This data can later be retrieved via a GET request to the /moisturereadings endpoint.