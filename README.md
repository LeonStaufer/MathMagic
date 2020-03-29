<p align="center">
  <a href="https://github.com/LeonStaufer/TeXTools">
    <img src="assets/logo.png" alt="Logo for TeX Tools" width="287" height="138" />
  </a>

  <p align="center">
    Android Library to display LaTeX equations
    <br />
    <br />
    <a href='https://bintray.com/leonstaufer/maven/textools/_latestVersion'><img src='https://api.bintray.com/packages/leonstaufer/maven/textools/images/download.svg'></a>
    <a href="https://github.com/LeonStaufer/TeXTools/issues/new"><img alt="GitHub issues" src="https://img.shields.io/github/issues/LeonStaufer/TeXTools"></a>
    <a href="https:://github.com/LeonStaufer/TeXTools"><img alt="Apache 2.0 License" src="https://img.shields.io/github/license/LeonStaufer/TeXTools"></a>
    <br />
  </p>
</p>

## Table of Contents

* [About](#about)
  * [Built With](#built-with)
* [Getting Started](#getting-started)
  * [Installation](#installation)
  * [Usage](#usage)
* [Configuration](#configuration)
* [Roadmap](#roadmap)
* [Contributing](#contributing)
* [License](#license)
* [Contact](#contact)



## About

![Screenshot of the TeX Tools Example App][product-screenshot]

**TeX Tools** is an Android library for rendering TeX equations. 


### Built With

This project provides an efficient wrapper for a WebView that renders TeX equations using [KaTeX][katex]. As such, it would not have been possible without the great work put into the KaTeX typesetting library for the web.

## Getting Started

### Installation

#### Maven

Add the dependency to your Maven build settings:

```xml
<dependency>
  <groupId>me.staufer</groupId>
  <artifactId>textools</artifactId>
  <version>1.0.2</version>
  <type>pom</type>
</dependency>
```

#### Gradle

Add the following the depedency section in your build.gradle:

```groovy
implementation 'me.staufer:textools:1.0.2'
```

### Usage

There are two ways to create a `MathView`: programmatically using Java/Kotlin or by defining it in the layout. In both cases, take a look at the [configuration section](#configuration) to see which parameters you can pass.

```xml
<me.staufer.textools.MathView
        android:layout_width="match_parent"
        android:layout_height="200dp"
        app:color="@color/colorAccent"
        app:colorBackground="@color/colorPrimaryDark"
        app:displayMode="true"
        app:tex="\\int x \\neq x^2 \\\\ \\text{Example in XML}" 
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"/>
```


The MathView can then be controlled programmatically:
```java
//get MathView component
final MathView mathView = findViewById(R.id.mathview);
mathView.setWebViewClient(new WebViewClient() {
    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);

        //render TeX once MathView has loaded
        //backslashes need to be escaped
        mathView.render("x \\times x = x^2 \\\\ \\text{Example in Java}");
    }
});
```

For more detailed overview of the example, please refer to the [app directory](https://github.com/LeonStaufer/TeXTools/tree/master/app).


## Configuration

#### MathView

You can change the following properties of the MathView.

| Key            | Description                                                  | Type                                              | Default |
| -------------- | ------------------------------------------------------------ | ------- | ------- |
| `tex`  | A string of TeX that should be rendered | `String` | `null` |
| `displayMode`  | "If `true` the math will be rendered in display mode, which will put the math in display style (so `\int` and `\sum` are large, for example), and will center the math on the page on its own line. If `false` the math will be rendered in inline mode." | `boolean` | `false` |
| `leqno`        | "If `true`, display math has `\tag`s rendered on the left instead of the right, like `\usepackage[leqno]{amsmath}` in LaTeX." | `boolean` | `false` |
| `fleqno`       | "If `true`, display math renders flush left, like `\documentclass[fleqn]` in LaTeX." | `boolean` | `false` |
| `throwOnError` | "If `true` (the default), KaTeX will throw a `ParseError` when it encounters an unsupported command or invalid LaTeX. If `false`, KaTeX will render unsupported commands as text, and render invalid  LaTeX as its source code with hover text giving the error, in the color  given by `errorColor`." | `boolean` | `false` |
| `color`        | The color of the TeX rendered in the MathView. | `Color` | `black` |
| `colorBackground` | The background color of the MathView. | `Color` | `white` |
| `colorError`   | A color that determines the color that unsupported commands and invalid LaTeX are rendered in when `throwOnError` is set to `false`. | `Color` | `#c00`  |

> Descriptions are partially quoted from the [KaTeX Docs][katex-docs].



<!-- ROADMAP -->

## Roadmap

Here's a list of additions that are planned for the future:

1. Interactive MathView
2. MathInput, that checks the TeX input for correctness and offers typing support

See the [open issues][issues] for a list of proposed features (and known issues).



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

Distributed under the Apache 2.0 License. See `LICENSE` for more information.



<!-- CONTACT -->
## Contact

If you have any questions, feel free to contact [Leon Staufer][email].

Project Link: [https://github.com/LeonStaufer/TeXTools][project]



<!-- MARKDOWN LINKS & IMAGES -->
[product-screenshot]: assets/screenshot.jpg
[project]: https://github.com/LeonStaufer/TeXTools
[issues]: https://github.com/LeonStaufer/TeXTools/issues
[email]: mailto:leon@staufer.me
[katex]: https://katex.org/
[katex-docs]: https://katex.org/docs/options.html
