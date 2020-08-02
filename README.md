
<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/othneildrew/Best-README-Template">
    <img src="logo.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">Ease Vision</h3>

  <p align="center">
   Ease Vision has been crafted as an innovative way to assess a population’s temperature in real time by collecting the data of individuals walking by. 
    <br />
    <a href="https://github.com/othneildrew/Best-README-Template"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/othneildrew/Best-README-Template">View Demo</a>
    ·
    <a href="https://github.com/othneildrew/Best-README-Template/issues">Report Bug</a>
    ·
    <a href="https://github.com/othneildrew/Best-README-Template/issues">Request Feature</a>
  </p>
</p>



<!-- TABLE OF CONTENTS -->
## Table of Contents

* [About the Project](#about-the-project)
  * [Built With](#built-with)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
* [Usage](#usage)
* [Roadmap](#roadmap)
* [Contributing](#contributing)
* [License](#license)
* [Contact](#contact)
* [Acknowledgements](#acknowledgements)



<!-- ABOUT THE PROJECT -->
## About The Project
The application works collaboratively with the data being provided by an OPENMV H7 camera running an infrared imaging sensor, Lepton 3.5, with a Wi-Fi shield. The OPENMV cam is an IOT device programmed in micro python. When placed in a public setting, the camera utilizes the average screen temperature and evaluates it to determine if a being is present. Once the program identifies a person(s), it saves the IR frame and sends the image to a Raspberry Pi. The microcontroller then makes an HTTP post request call to the IBM Watson visual recognition service, which analyzes the image to locate a face(s). The Raspberry Pi is essential to the system since the OpenMV CAM lacks the ability to perform certain API calls. On return, the camera will receive the coordinates of where the face(s) were present in the frame. These coordinates are then utilized to give a mean temperature reading of the returned area. The OpenMV camera then evaluates if the assessed temperature is considered elevated or non-elevated based on WebMD’s fever temperature reading. This data then goes into a count-based variable, which on interval is pushed to IOT platform. This IOT service will receive not only the number of elevated and non-elevated temperature readings, but all information about the device’s specific location. On the other hand, the Android app has been programmed in Java to receive all the data from the IOT platform. On the start screen the application prompts the user for their country, state, and city. After all the information is filled, the selected city’s data as well as a surrounding map is displayed. The severity of the location is shown by a red marker, additionally, in the left corner the number of elevated vs non elevated individuals is further dissected.  The collaborative work between the OpenMV CAM running a Lepton sensor has much potential in accurately visualizing areas of high risk as well as predicting future outbreaks. Due to my financial status I am currently limited to one camera, but I strongly believe the capabilities of this application to help our society immensely. I strive to have these sensors throughout cities, malls, and populated areas of interest across the world. This would gather much data on a population allowing one to understand today’s situation and predict tomorrows. Currently, the majority of people rely on the number of confirmed cases to assess the situation of a specific place. However, the number of cases will not pinpoint a live exact location’s severity nor tell you who is currently ill and not quarantining. This information would not only assist common persons, but moreover, essential workers and government officials to best prepare for the next day. 

### Built With
![layout](layout.PNG?raw=true "Optional Title")
This project incorporates works collaboralively with a [OPENMV H7 Camera]("https://github.com/andrewkaram1/EaseVision_OpenMV-Cam") and a [rabserry PI](https://github.com/andrewkaram1/EaseVision-RasberryPI), which collaboratively leverages cloud computing.
*[IBM Cloud Service](https://www.ibm.com/cloud/services)
  * [IBM Watson Visual Recognition](https://www.ibm.com/cloud/watson-visual-recognition)
  * [IBM Watson IOT](https://www.ibm.com/internet-of-things)



<!-- GETTING STARTED -->
## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### Prerequisites

This is an example of how to list things you need to use the software and how to install them.
* npm
```sh
npm install npm@latest -g
```

### Installation

1. Get a free API Key at [https://example.com](https://example.com)
2. Clone the repo
```sh
git clone https://github.com/your_username_/Project-Name.git
```
3. Install NPM packages
```sh
npm install
```
4. Enter your API in `config.js`
```JS
const API_KEY = 'ENTER YOUR API';
```



<!-- USAGE EXAMPLES -->
## Usage

Use this space to show useful examples of how a project can be used. Additional screenshots, code examples and demos work well in this space. You may also link to more resources.

_For more examples, please refer to the [Documentation](https://example.com)_



<!-- ROADMAP -->
## Roadmap

![Alt text](FINAL%20AK-1.jpg?raw=true "Optional Title")



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.



<!-- CONTACT -->
## Contact

Your Name - [@your_twitter](https://twitter.com/your_username) - email@example.com

Project Link: [https://github.com/your_username/repo_name](https://github.com/your_username/repo_name)



<!-- ACKNOWLEDGEMENTS -->
## Acknowledgements
* [GitHub Emoji Cheat Sheet](https://www.webpagefx.com/tools/emoji-cheat-sheet)
* [Img Shields](https://shields.io)
* [Choose an Open Source License](https://choosealicense.com)
* [GitHub Pages](https://pages.github.com)
* [Animate.css](https://daneden.github.io/animate.css)
* [Loaders.css](https://connoratherton.com/loaders)
* [Slick Carousel](https://kenwheeler.github.io/slick)
* [Smooth Scroll](https://github.com/cferdinandi/smooth-scroll)
* [Sticky Kit](http://leafo.net/sticky-kit)
* [JVectorMap](http://jvectormap.com)
* [Font Awesome](https://fontawesome.com)





<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=flat-square
[contributors-url]: https://github.com/othneildrew/Best-README-Template/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/othneildrew/Best-README-Template.svg?style=flat-square
[forks-url]: https://github.com/othneildrew/Best-README-Template/network/members
[stars-shield]: https://img.shields.io/github/stars/othneildrew/Best-README-Template.svg?style=flat-square
[stars-url]: https://github.com/othneildrew/Best-README-Template/stargazers
[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=flat-square
[issues-url]: https://github.com/othneildrew/Best-README-Template/issues
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=flat-square
[license-url]: https://github.com/othneildrew/Best-README-Template/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=flat-square&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/othneildrew
[product-screenshot]: images/screenshot.png



![Alt text](FINAL%20AK-1.jpg?raw=true "Optional Title")
