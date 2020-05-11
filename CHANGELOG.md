# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/), and this project adheres to [Semantic Versioning](https://semver.org/).

## [1.0.4] - 2020-03-27

### Added

- new performance activity to showcase how efficiently it renders with 100 MathViews

### Changed

- base64 decoding in `index.html` to correctly handle all unicode characters

## [1.0.3] - 2020-03-27

### Added

- HTML meta tags to `index.html`
- TeX Buffer to `MathView` so that `render()` can be called immediately
- option to change font size

### Changed

- lowered minimum SDK version to 17
- restricted WebView settings
- encoding of TeX to base 64

## [1.0.2] - 2020-03-29

### Changed
- Project name from `Math Magic` to `TeX Tools`
- All module occurances to `textools`
- maven package name to `textools`
- `publish.gradle` to make better use of variables

## [1.0.1] - 2020-03-27

### Added

- `attrs.xml` that allows MathView attributes to be set from XML

### Changed

- MathView class to use AttributeSet
- how MathView first renders the TeX
- `index.html` initialization process
- CSS style in `index.html` to fill the entire viewport
- Example to show the different ways MathView can be used

## [1.0.0] - 2020-03-26

### Added

- MathView class that renders TeX using the native WebView
- `index.html` that uses KaTeX to render TeX strings passed via JS
- necessary KaTeX depedency
- Example to show how MathView can be used
- `build.gradle` and `publish.gradle` files to manage publishing to Bintray

[unreleased]: https://github.com/LeonStaufer/TeXTools/compare/v1.0.4...HEAD
[1.0.4]: https://github.com/LeonStaufer/TeXTools/compare/v1.0.3...v1.0.4
[1.0.3]: https://github.com/LeonStaufer/TeXTools/compare/v1.0.2...v1.0.3
[1.0.2]: https://github.com/LeonStaufer/TeXTools/compare/v1.0.1...v1.0.2
[1.0.1]: https://github.com/LeonStaufer/TeXTools/compare/v1.0.0...v1.0.1
[1.0.0]: https://github.com/LeonStaufer/TeXTools/releases/tag/v1.0.0
