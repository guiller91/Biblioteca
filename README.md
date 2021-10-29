<html><head><meta http-equiv="Content-Type" content="text/html; charset=utf-8"/><title>Actividad 2 - Sockets</title><style>
/* cspell:disable-file */
/* webkit printing magic: print all background colors */
html {
	-webkit-print-color-adjust: exact;
}
* {
	box-sizing: border-box;
	-webkit-print-color-adjust: exact;
}

html,
body {
	margin: 0;
	padding: 0;
}
@media only screen {
	body {
		margin: 2em auto;
		max-width: 900px;
		color: rgb(55, 53, 47);
	}
}

body {
	line-height: 1.5;
	white-space: pre-wrap;
}

a,
a.visited {
	color: inherit;
	text-decoration: underline;
}

.pdf-relative-link-path {
	font-size: 80%;
	color: #444;
}

h1,
h2,
h3 {
	letter-spacing: -0.01em;
	line-height: 1.2;
	font-weight: 600;
	margin-bottom: 0;
}

.page-title {
	font-size: 2.5rem;
	font-weight: 700;
	margin-top: 0;
	margin-bottom: 0.75em;
}

h1 {
	font-size: 1.875rem;
	margin-top: 1.875rem;
}

h2 {
	font-size: 1.5rem;
	margin-top: 1.5rem;
}

h3 {
	font-size: 1.25rem;
	margin-top: 1.25rem;
}

.source {
	border: 1px solid #ddd;
	border-radius: 3px;
	padding: 1.5em;
	word-break: break-all;
}

.callout {
	border-radius: 3px;
	padding: 1rem;
}

figure {
	margin: 1.25em 0;
	page-break-inside: avoid;
}

figcaption {
	opacity: 0.5;
	font-size: 85%;
	margin-top: 0.5em;
}

mark {
	background-color: transparent;
}

.indented {
	padding-left: 1.5em;
}

hr {
	background: transparent;
	display: block;
	width: 100%;
	height: 1px;
	visibility: visible;
	border: none;
	border-bottom: 1px solid rgba(55, 53, 47, 0.09);
}

img {
	max-width: 100%;
}

@media only print {
	img {
		max-height: 100vh;
		object-fit: contain;
	}
}

@page {
	margin: 1in;
}

.collection-content {
	font-size: 0.875rem;
}

.column-list {
	display: flex;
	justify-content: space-between;
}

.column {
	padding: 0 1em;
}

.column:first-child {
	padding-left: 0;
}

.column:last-child {
	padding-right: 0;
}

.table_of_contents-item {
	display: block;
	font-size: 0.875rem;
	line-height: 1.3;
	padding: 0.125rem;
}

.table_of_contents-indent-1 {
	margin-left: 1.5rem;
}

.table_of_contents-indent-2 {
	margin-left: 3rem;
}

.table_of_contents-indent-3 {
	margin-left: 4.5rem;
}

.table_of_contents-link {
	text-decoration: none;
	opacity: 0.7;
	border-bottom: 1px solid rgba(55, 53, 47, 0.18);
}

table,
th,
td {
	border: 1px solid rgba(55, 53, 47, 0.09);
	border-collapse: collapse;
}

table {
	border-left: none;
	border-right: none;
}

th,
td {
	font-weight: normal;
	padding: 0.25em 0.5em;
	line-height: 1.5;
	min-height: 1.5em;
	text-align: left;
}

th {
	color: rgba(55, 53, 47, 0.6);
}

ol,
ul {
	margin: 0;
	margin-block-start: 0.6em;
	margin-block-end: 0.6em;
}

li > ol:first-child,
li > ul:first-child {
	margin-block-start: 0.6em;
}

ul > li {
	list-style: disc;
}

ul.to-do-list {
	text-indent: -1.7em;
}

ul.to-do-list > li {
	list-style: none;
}

.to-do-children-checked {
	text-decoration: line-through;
	opacity: 0.375;
}

ul.toggle > li {
	list-style: none;
}

ul {
	padding-inline-start: 1.7em;
}

ul > li {
	padding-left: 0.1em;
}

ol {
	padding-inline-start: 1.6em;
}

ol > li {
	padding-left: 0.2em;
}

.mono ol {
	padding-inline-start: 2em;
}

.mono ol > li {
	text-indent: -0.4em;
}

.toggle {
	padding-inline-start: 0em;
	list-style-type: none;
}

/* Indent toggle children */
.toggle > li > details {
	padding-left: 1.7em;
}

.toggle > li > details > summary {
	margin-left: -1.1em;
}

.selected-value {
	display: inline-block;
	padding: 0 0.5em;
	background: rgba(206, 205, 202, 0.5);
	border-radius: 3px;
	margin-right: 0.5em;
	margin-top: 0.3em;
	margin-bottom: 0.3em;
	white-space: nowrap;
}

.collection-title {
	display: inline-block;
	margin-right: 1em;
}

time {
	opacity: 0.5;
}

.icon {
	display: inline-block;
	max-width: 1.2em;
	max-height: 1.2em;
	text-decoration: none;
	vertical-align: text-bottom;
	margin-right: 0.5em;
}

img.icon {
	border-radius: 3px;
}

.user-icon {
	width: 1.5em;
	height: 1.5em;
	border-radius: 100%;
	margin-right: 0.5rem;
}

.user-icon-inner {
	font-size: 0.8em;
}

.text-icon {
	border: 1px solid #000;
	text-align: center;
}

.page-cover-image {
	display: block;
	object-fit: cover;
	width: 100%;
	height: 30vh;
}

.page-header-icon {
	font-size: 3rem;
	margin-bottom: 1rem;
}

.page-header-icon-with-cover {
	margin-top: -0.72em;
	margin-left: 0.07em;
}

.page-header-icon img {
	border-radius: 3px;
}

.link-to-page {
	margin: 1em 0;
	padding: 0;
	border: none;
	font-weight: 500;
}

p > .user {
	opacity: 0.5;
}

td > .user,
td > time {
	white-space: nowrap;
}

input[type="checkbox"] {
	transform: scale(1.5);
	margin-right: 0.6em;
	vertical-align: middle;
}

p {
	margin-top: 0.5em;
	margin-bottom: 0.5em;
}

.image {
	border: none;
	margin: 1.5em 0;
	padding: 0;
	border-radius: 0;
	text-align: center;
}

.code,
code {
	background: rgba(135, 131, 120, 0.15);
	border-radius: 3px;
	padding: 0.2em 0.4em;
	border-radius: 3px;
	font-size: 85%;
	tab-size: 2;
}

code {
	color: #eb5757;
}

.code {
	padding: 1.5em 1em;
}

.code-wrap {
	white-space: pre-wrap;
	word-break: break-all;
}

.code > code {
	background: none;
	padding: 0;
	font-size: 100%;
	color: inherit;
}

blockquote {
	font-size: 1.25em;
	margin: 1em 0;
	padding-left: 1em;
	border-left: 3px solid rgb(55, 53, 47);
}

.bookmark {
	text-decoration: none;
	max-height: 8em;
	padding: 0;
	display: flex;
	width: 100%;
	align-items: stretch;
}

.bookmark-title {
	font-size: 0.85em;
	overflow: hidden;
	text-overflow: ellipsis;
	height: 1.75em;
	white-space: nowrap;
}

.bookmark-text {
	display: flex;
	flex-direction: column;
}

.bookmark-info {
	flex: 4 1 180px;
	padding: 12px 14px 14px;
	display: flex;
	flex-direction: column;
	justify-content: space-between;
}

.bookmark-image {
	width: 33%;
	flex: 1 1 180px;
	display: block;
	position: relative;
	object-fit: cover;
	border-radius: 1px;
}

.bookmark-description {
	color: rgba(55, 53, 47, 0.6);
	font-size: 0.75em;
	overflow: hidden;
	max-height: 4.5em;
	word-break: break-word;
}

.bookmark-href {
	font-size: 0.75em;
	margin-top: 0.25em;
}

.sans { font-family: ui-sans-serif, -apple-system, BlinkMacSystemFont, "Segoe UI", Helvetica, "Apple Color Emoji", Arial, sans-serif, "Segoe UI Emoji", "Segoe UI Symbol"; }
.code { font-family: "SFMono-Regular", Menlo, Consolas, "PT Mono", "Liberation Mono", Courier, monospace; }
.serif { font-family: Lyon-Text, Georgia, ui-serif, serif; }
.mono { font-family: iawriter-mono, Nitti, Menlo, Courier, monospace; }
.pdf .sans { font-family: Inter, ui-sans-serif, -apple-system, BlinkMacSystemFont, "Segoe UI", Helvetica, "Apple Color Emoji", Arial, sans-serif, "Segoe UI Emoji", "Segoe UI Symbol", 'Twemoji', 'Noto Color Emoji', 'Noto Sans CJK JP'; }
.pdf:lang(zh-CN) .sans { font-family: Inter, ui-sans-serif, -apple-system, BlinkMacSystemFont, "Segoe UI", Helvetica, "Apple Color Emoji", Arial, sans-serif, "Segoe UI Emoji", "Segoe UI Symbol", 'Twemoji', 'Noto Color Emoji', 'Noto Sans CJK SC'; }
.pdf:lang(zh-TW) .sans { font-family: Inter, ui-sans-serif, -apple-system, BlinkMacSystemFont, "Segoe UI", Helvetica, "Apple Color Emoji", Arial, sans-serif, "Segoe UI Emoji", "Segoe UI Symbol", 'Twemoji', 'Noto Color Emoji', 'Noto Sans CJK TC'; }
.pdf:lang(ko-KR) .sans { font-family: Inter, ui-sans-serif, -apple-system, BlinkMacSystemFont, "Segoe UI", Helvetica, "Apple Color Emoji", Arial, sans-serif, "Segoe UI Emoji", "Segoe UI Symbol", 'Twemoji', 'Noto Color Emoji', 'Noto Sans CJK KR'; }
.pdf .code { font-family: Source Code Pro, "SFMono-Regular", Menlo, Consolas, "PT Mono", "Liberation Mono", Courier, monospace, 'Twemoji', 'Noto Color Emoji', 'Noto Sans Mono CJK JP'; }
.pdf:lang(zh-CN) .code { font-family: Source Code Pro, "SFMono-Regular", Menlo, Consolas, "PT Mono", "Liberation Mono", Courier, monospace, 'Twemoji', 'Noto Color Emoji', 'Noto Sans Mono CJK SC'; }
.pdf:lang(zh-TW) .code { font-family: Source Code Pro, "SFMono-Regular", Menlo, Consolas, "PT Mono", "Liberation Mono", Courier, monospace, 'Twemoji', 'Noto Color Emoji', 'Noto Sans Mono CJK TC'; }
.pdf:lang(ko-KR) .code { font-family: Source Code Pro, "SFMono-Regular", Menlo, Consolas, "PT Mono", "Liberation Mono", Courier, monospace, 'Twemoji', 'Noto Color Emoji', 'Noto Sans Mono CJK KR'; }
.pdf .serif { font-family: PT Serif, Lyon-Text, Georgia, ui-serif, serif, 'Twemoji', 'Noto Color Emoji', 'Noto Serif CJK JP'; }
.pdf:lang(zh-CN) .serif { font-family: PT Serif, Lyon-Text, Georgia, ui-serif, serif, 'Twemoji', 'Noto Color Emoji', 'Noto Serif CJK SC'; }
.pdf:lang(zh-TW) .serif { font-family: PT Serif, Lyon-Text, Georgia, ui-serif, serif, 'Twemoji', 'Noto Color Emoji', 'Noto Serif CJK TC'; }
.pdf:lang(ko-KR) .serif { font-family: PT Serif, Lyon-Text, Georgia, ui-serif, serif, 'Twemoji', 'Noto Color Emoji', 'Noto Serif CJK KR'; }
.pdf .mono { font-family: PT Mono, iawriter-mono, Nitti, Menlo, Courier, monospace, 'Twemoji', 'Noto Color Emoji', 'Noto Sans Mono CJK JP'; }
.pdf:lang(zh-CN) .mono { font-family: PT Mono, iawriter-mono, Nitti, Menlo, Courier, monospace, 'Twemoji', 'Noto Color Emoji', 'Noto Sans Mono CJK SC'; }
.pdf:lang(zh-TW) .mono { font-family: PT Mono, iawriter-mono, Nitti, Menlo, Courier, monospace, 'Twemoji', 'Noto Color Emoji', 'Noto Sans Mono CJK TC'; }
.pdf:lang(ko-KR) .mono { font-family: PT Mono, iawriter-mono, Nitti, Menlo, Courier, monospace, 'Twemoji', 'Noto Color Emoji', 'Noto Sans Mono CJK KR'; }
.highlight-default {
	color: rgba(55, 53, 47, 1);
}
.highlight-gray {
	color: rgba(120, 119, 116, 1);
	fill: rgba(145, 145, 142, 1);
}
.highlight-brown {
	color: rgba(159, 107, 83, 1);
	fill: rgba(187, 132, 108, 1);
}
.highlight-orange {
	color: rgba(217, 115, 13, 1);
	fill: rgba(215, 129, 58, 1);
}
.highlight-yellow {
	color: rgba(203, 145, 47, 1);
	fill: rgba(203, 148, 51, 1);
}
.highlight-teal {
	color: rgba(68, 131, 97, 1);
	fill: rgba(108, 155, 125, 1);
}
.highlight-blue {
	color: rgba(51, 126, 169, 1);
	fill: rgba(91, 151, 189, 1);
}
.highlight-purple {
	color: rgba(144, 101, 176, 1);
	fill: rgba(167, 130, 195, 1);
}
.highlight-pink {
	color: rgba(193, 76, 138, 1);
	fill: rgba(205, 116, 159, 1);
}
.highlight-red {
	color: rgba(212, 76, 71, 1);
	fill: rgba(225, 111, 100, 1);
}
.highlight-gray_background {
	background: rgba(241, 241, 239, 1);
}
.highlight-brown_background {
	background: rgba(244, 238, 238, 1);
}
.highlight-orange_background {
	background: rgba(251, 236, 221, 1);
}
.highlight-yellow_background {
	background: rgba(251, 243, 219, 1);
}
.highlight-teal_background {
	background: rgba(237, 243, 236, 1);
}
.highlight-blue_background {
	background: rgba(231, 243, 248, 1);
}
.highlight-purple_background {
	background: rgba(244, 240, 247, 0.8);
}
.highlight-pink_background {
	background: rgba(249, 238, 243, 0.8);
}
.highlight-red_background {
	background: rgba(253, 235, 236, 1);
}
.block-color-default {
	color: inherit;
	fill: inherit;
}
.block-color-gray {
	color: rgba(120, 119, 116, 1);
	fill: rgba(145, 145, 142, 1);
}
.block-color-brown {
	color: rgba(159, 107, 83, 1);
	fill: rgba(187, 132, 108, 1);
}
.block-color-orange {
	color: rgba(217, 115, 13, 1);
	fill: rgba(215, 129, 58, 1);
}
.block-color-yellow {
	color: rgba(203, 145, 47, 1);
	fill: rgba(203, 148, 51, 1);
}
.block-color-teal {
	color: rgba(68, 131, 97, 1);
	fill: rgba(108, 155, 125, 1);
}
.block-color-blue {
	color: rgba(51, 126, 169, 1);
	fill: rgba(91, 151, 189, 1);
}
.block-color-purple {
	color: rgba(144, 101, 176, 1);
	fill: rgba(167, 130, 195, 1);
}
.block-color-pink {
	color: rgba(193, 76, 138, 1);
	fill: rgba(205, 116, 159, 1);
}
.block-color-red {
	color: rgba(212, 76, 71, 1);
	fill: rgba(225, 111, 100, 1);
}
.block-color-gray_background {
	background: rgba(241, 241, 239, 1);
}
.block-color-brown_background {
	background: rgba(244, 238, 238, 1);
}
.block-color-orange_background {
	background: rgba(251, 236, 221, 1);
}
.block-color-yellow_background {
	background: rgba(251, 243, 219, 1);
}
.block-color-teal_background {
	background: rgba(237, 243, 236, 1);
}
.block-color-blue_background {
	background: rgba(231, 243, 248, 1);
}
.block-color-purple_background {
	background: rgba(244, 240, 247, 0.8);
}
.block-color-pink_background {
	background: rgba(249, 238, 243, 0.8);
}
.block-color-red_background {
	background: rgba(253, 235, 236, 1);
}
.select-value-color-pink { background-color: rgba(245, 224, 233, 1); }
.select-value-color-purple { background-color: rgba(232, 222, 238, 1); }
.select-value-color-green { background-color: rgba(219, 237, 219, 1); }
.select-value-color-gray { background-color: rgba(227, 226, 224, 1); }
.select-value-color-orange { background-color: rgba(250, 222, 201, 1); }
.select-value-color-brown { background-color: rgba(238, 224, 218, 1); }
.select-value-color-red { background-color: rgba(255, 226, 221, 1); }
.select-value-color-yellow { background-color: rgba(253, 236, 200, 1); }
.select-value-color-blue { background-color: rgba(211, 229, 239, 1); }

.checkbox {
	display: inline-flex;
	vertical-align: text-bottom;
	width: 16;
	height: 16;
	background-size: 16px;
	margin-left: 2px;
	margin-right: 5px;
}

.checkbox-on {
	background-image: url("data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%2216%22%20height%3D%2216%22%20viewBox%3D%220%200%2016%2016%22%20fill%3D%22none%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%3E%0A%3Crect%20width%3D%2216%22%20height%3D%2216%22%20fill%3D%22%2358A9D7%22%2F%3E%0A%3Cpath%20d%3D%22M6.71429%2012.2852L14%204.9995L12.7143%203.71436L6.71429%209.71378L3.28571%206.2831L2%207.57092L6.71429%2012.2852Z%22%20fill%3D%22white%22%2F%3E%0A%3C%2Fsvg%3E");
}

.checkbox-off {
	background-image: url("data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%2216%22%20height%3D%2216%22%20viewBox%3D%220%200%2016%2016%22%20fill%3D%22none%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%3E%0A%3Crect%20x%3D%220.75%22%20y%3D%220.75%22%20width%3D%2214.5%22%20height%3D%2214.5%22%20fill%3D%22white%22%20stroke%3D%22%2336352F%22%20stroke-width%3D%221.5%22%2F%3E%0A%3C%2Fsvg%3E");
}
	
</style></head><body><article id="01c80f4d-6eb9-45b3-80a4-8cb2c30cd781" class="page sans"><header><img class="page-cover-image" src="https://images.unsplash.com/photo-1517650862521-d580d5348145?ixlib=rb-1.2.1&amp;q=85&amp;fm=jpg&amp;crop=entropy&amp;cs=srgb" style="object-position:center 50%"/><div class="page-header-icon page-header-icon-with-cover"><span class="icon">🧑🏻‍💻</span></div><h1 class="page-title">Actividad 2 - Sockets</h1></header><div class="page-body"><h3 id="dfb8deeb-7b10-40f3-941f-5ee7a2bbb481" class="">Miembros del grupo:</h3><ul id="e013b22c-3aa1-4ada-a93c-92a3ae89abd7" class="bulleted-list"><li style="list-style-type:disc"><a href="https://github.com/IGaitanM">Iván Gaitán Muñoz</a> </li></ul><ul id="34019091-483a-408d-844a-5e251f947ae6" class="bulleted-list"><li style="list-style-type:disc"><a href="https://github.com/luzlozas">Luz Maria Lozano Asimbaya</a></li></ul><ul id="8a63c6d7-4639-4974-b3c2-545b5e41df89" class="bulleted-list"><li style="list-style-type:disc"><a href="https://github.com/miguelperezlarren">Miguel Pérez Larren</a></li></ul><ul id="cef84ace-49c0-4bc1-98d2-f0a5b81333e6" class="bulleted-list"><li style="list-style-type:disc"><a href="https://github.com/guiller91">Guillermo Pérez Arias</a></li></ul><p id="f26987c6-9d2b-4263-a36d-c867546cdba8" class="">
</p><h2 id="32806600-db76-4768-a8c6-4b0039aaed68" class="">Objetivos</h2><ul id="04fab907-61b2-4bb5-a16f-fbf9f809a82c" class="to-do-list"><li><div class="checkbox checkbox-on"></div> <span class="to-do-children-checked">Programa Cliente-Servidor que gestione una librería virtual alojada en el server.</span></li></ul><ul id="08d306d9-c209-4193-a5a8-6398c06c512e" class="to-do-list"><li><div class="checkbox checkbox-on"></div> <span class="to-do-children-checked">Un menú en la aplicación cliente que nos de las siguientes funcionalidades</span><ul id="defabf29-81ce-4672-b54b-183fd78f2c69" class="to-do-list"><li><div class="checkbox checkbox-on"></div> <span class="to-do-children-checked">Consultar libro por ISBN</span></li></ul><ul id="1fe6b262-2f2a-4998-b609-130faf85094b" class="to-do-list"><li><div class="checkbox checkbox-on"></div> <span class="to-do-children-checked">Consultar libro por Titulo</span></li></ul><ul id="3ec321c0-5735-4a31-92bf-6fc944082db4" class="to-do-list"><li><div class="checkbox checkbox-on"></div> <span class="to-do-children-checked">Consultar libro por autor</span></li></ul><ul id="408f5973-c8ae-4389-b3d6-143a5469c34a" class="to-do-list"><li><div class="checkbox checkbox-on"></div> <span class="to-do-children-checked">Añadir Libro</span></li></ul><ul id="9ecfa283-ba1a-4b0e-afc1-35f29360c821" class="to-do-list"><li><div class="checkbox checkbox-on"></div> <span class="to-do-children-checked">Salir de la aplicación</span></li></ul></li></ul><ul id="00c72da4-cadf-4433-9726-665ae9096904" class="to-do-list"><li><div class="checkbox checkbox-on"></div> <span class="to-do-children-checked">Soporte de hilos en servidor</span></li></ul><p id="c181a619-c7bb-4af1-9500-9eb25a5c7331" class="">
</p><h2 id="f93d41ad-b88c-4caa-b748-79212c3aff49" class="">Solución aportada</h2><p id="8479d756-bfb0-44ca-8bfe-c728f23e3427" class="">Nos hemos decantado por un proyecto Maven para poder implementar la dependencia de JSON y poder operar con el, como vía de comunicación con el servidor. De esta manera nos facilitara a la hora de recibir los datos y poder operar con ellos en el servidor.</p><p id="749a9442-333b-4925-ab5f-09891dfbf956" class="">
</p><h2 id="a4d7d296-04de-42a1-8942-baa849808e3d" class="">Explicación de puntos clave</h2><p id="550a3246-3aee-46c6-9ea6-c932b07ebdb4" class="">
</p><h3 id="d7f65493-31eb-43cb-9285-2cabdfccd6db" class="">Cliente</h3><hr id="46f96a2f-f263-44ef-a8d2-e861e0c79688"/><p id="aa940464-a8d3-4c5c-9efc-54ed6da55558" class="">Para el menú del cliente hemos usado un <code>Switch{}</code> para movernos entre las opciones del menú.</p><pre id="a2d3279d-e8c1-46f3-93ef-eeec7d0ed46d" class="code"><code>System.out.println(&quot;Elige una número del menu:\n&quot;+&quot;1. Consultar libro por ISBN\n&quot;+&quot;2. Consultar libro por titulo\n&quot;+
									&quot;3. Consultar libros por autor\n&quot; + &quot;4. Añadir libro\n&quot; + &quot;5. Salir de la aplicación&quot; );
				num = Integer.parseInt(sc.nextLine());
				
				switch (num) {
				case 1:
					libro = new Libro();
					System.out.println(&quot;Introduzca el ISBN&quot;);
					texto = sc.nextLine();
					libro.setIsbn(texto);
					json = gson.toJson(libro);
					break;					
				case 2:					
					libro = new Libro();
					System.out.println(&quot;Introduzca el título&quot;);
					texto = sc.nextLine();
					libro.setTitulo(texto);
					json = gson.toJson(libro);
					break;
				case 3:
					libro = new Libro();
					System.out.println(&quot;Introduzca el autor&quot;);
					texto = sc.nextLine();
					libro.setAutor(texto);
					json = gson.toJson(libro);
					break;
				case 4:					
					libro=new Libro();
					System.out.println(&quot;Introduzca un ISBN&quot;);
					texto = sc.nextLine();
					libro.setIsbn(texto);
					System.out.println(&quot;Introduzca el título&quot;);
					texto = sc.nextLine();
					libro.setTitulo(texto);
					System.out.println(&quot;Introduzca el autor&quot;);
					texto = sc.nextLine();
					libro.setAutor(texto);
					System.out.println(&quot;Introduzca el precio&quot;);
					int precio = Integer.parseInt(sc.nextLine());
					libro.setPrecio(precio);
					json = gson.toJson(libro);									
					break;					
				case 5:
					System.out.println(&quot;Saliendo de la aplicación....&quot;);
					json=&quot;FIN&quot;;
					continuar=false;
					break;
				default:
					System.out.println(&quot;Introduzca un numero del menu&quot;);;
				}</code></pre><p id="8012c479-068a-44f9-8d67-1510436c514d" class="">Como curiosidad, hemos tenido que usar <code>Scanner.nextLine()</code>, para poder recoger espacios, por si el usuario quería dar una opción con varias palabras. Al usar el tipo<code> Integer</code>  para el precio del libro, hemos tenido que usar el <code>Integer.parseInt(scanner.nextLine()) </code> para que no nos diera un error de salto de línea a la hora de interactuar con el menú.</p><p id="68d20b5b-da7b-48ba-9bd4-93fe7ba4664f" class="">Para enviar la información al servidor, lo haremos mediante un objeto <code>Libro</code> convertido a JSON.
<code>gson.toJson(libro)</code>.</p><p id="0237df70-a3e4-47a9-8d6c-80bb916f3b65" class="">El servidor nos contestara devolviéndonos un <code>String</code> compuesto por  la información del libro( si es que existe ) o de varios libros si es necesario. El patrón que hemos establecido es que si son varios libros los separaran mediante <code>@@.</code></p><p id="f8358a07-f235-408c-8b79-3376cff1b2b2" class="">Como ejemplo <code>Libro.toString()@@Libro2.toString()</code> , por lo cual tomamos de referencia las <code>@@</code> y las sustituiremos por un salto de línea. <code>respuesta.replaceAll(&quot;@@&quot;, &quot;\n&quot;)</code></p><p id="10dbdbc4-c9e3-445e-a67a-7c7c6f64a600" class="">Si el usuario quiere cerrar la aplicación, enviaremos un <code>&quot;FIN&quot;</code> al servidor y usaremos <code>continuar=false</code> para poder salir del bucle y cerraremos conexión <code>socketAlServidor.close()</code>.</p><p id="57d7b24c-6500-4449-9dfb-0a290a977b26" class="">
</p><h3 id="bb91bf10-abf9-4fc8-9291-46619607f4be" class="">Servidor</h3><hr id="5b714fcc-4c2a-4ff6-ab66-58f47b1273b8"/><p id="5951df49-aa7a-4026-b0ad-ac5d097b669a" class="">Hemos usado un servidor que acepte varios clientes mediante hilos. Entonces cada vez que entre una petición de un cliente se la asignaremos a un nuevo hilo.</p><pre id="1c9d07fe-7053-4b64-9ffc-d940c3f86b5d" class="code"><code>Socket socketAlCliente = servidor.accept();
System.out.println(&quot;SERVIDOR: peticion numero &quot; + ++peticion + &quot; recibida&quot;);
//Creación de nuevo hilo por cada cliente que solicite.				
new Hilo(socketAlCliente);</code></pre><p id="a373e125-0523-4d28-a76a-8aa86037059d" class="">
</p><p id="6e778043-8507-45c4-ab1c-b0edce68598b" class="">Hemos usado una Biblioteca  usando un <code>ArrayList&lt;Libros&gt; libros = new ArrayList&lt;Libros&gt;()</code>con 5 libros ya predefinidos.</p><p id="d2769dcc-40a7-4b6a-ba42-aaf5c6dfbb77" class="">Añadimos varios métodos para la problemática que plantea el problema. Empezaremos por el de registrar un libro.  Nos pasan un objeto <code>Libro</code> y lo agregamos al <code>ArrayList</code> mediante  <code>libros.add(libro)</code></p><p id="fd128eb3-1725-4895-86d5-cb593827c696" class="">Para buscar un Libro por su ISBN recorreremos el Array mediante un bucle pasando el valor a un libro creado y si lo encuentra nos devolverá <code>libro.toString()</code>. En caso de no encontrarlo, nos devolverá un <code>String</code> con el mensaje de <em>&quot;No se encontró el libro&quot;</em></p><pre id="2304a106-62d5-40a3-8781-d21d595a4323" class="code"><code>public String buscarLibroByCodigo(String codigoLibro){
        Libro libro;           
        for(int i=0; i&lt;libros.size(); i++){
            libro=libros.get(i);
            
            if(libro.getIsbn().equals(codigoLibro)){
                return libro.toString();                
            }
        }        
        return &quot;No se encontro el libro&quot;;
    }</code></pre><p id="943be0cf-0da4-4a13-8290-99b68ed0156c" class="">Para buscar el libro mediante su titulo, el funcionamiento es el mismo que el método anterior.</p><pre id="ea1e76b0-6480-4dfe-8f90-aa8e758f72af" class="code"><code>public String buscarLibroByTitulo(String titulo){
        Libro libro;        
        for(int i=0; i&lt;libros.size(); i++){
            libro=libros.get(i);
            
            if(libro.getTitulo().equals(titulo)){
                return libro.toString();                
            }
        }        
        return &quot;No se encontro el libro&quot;;
    }</code></pre><p id="8f0525f4-b110-4bf2-9d5a-bdca9658c94a" class="">Para buscar el libro mediante Autor, tenemos que tener en cuenta que un Autor puede tener varios libros, por lo cuál tendremos que devolver todos los libros. Como solo vamos a devolver un <code>String </code>al cliente, recorremos el Array y cada vez que encuentre un Libro de dicho Autor lo añadirá y concatenara junto con <code>@@</code> ( para que el cliente sepa que aquí tiene que meter un salto de línea)</p><p id="2c7f828b-991d-4cc0-9c17-6ebd5e57794b" class=""><code>texto = texto + &quot;@@&quot; +libro.toString();</code></p><p id="35e82737-b405-44ea-9007-17d982e78249" class="">Añadiremos la condición <code>if(i==(libros.size()-1)) {return texto;}</code> para que nos devuelva el <code>texto</code> solo cuando haya recorrido todo el Array, para asegurarnos que nos coge todos los libros.</p><pre id="113eaa96-5e13-4b63-8466-a0c8a9a77383" class="code"><code>public String buscarLibroByAutor(String autor){
        Libro libro= new Libro();
        texto=&quot;Los libros encontrados son:&quot;;
        for(int i=0; i&lt;libros.size(); i++){
            libro=libros.get(i);
            
            if(libro.getAutor().equals(autor)){                
                texto = texto + &quot;@@&quot; +libro.toString();
                if(i==(libros.size()-1)) {
                	return texto;
                }
            }
        }       
        return &quot;Libro no encontrado&quot;;
    }</code></pre><p id="47e3b45d-3b3d-4e32-84b7-07b8607b9438" class="">
</p><p id="954a276c-d193-492c-ac6d-6c60d38658a9" class="">Para evaluar la petición del cliente, lo hemos añadido con las siguientes condiciones:</p><pre id="a04b8775-8b16-40d6-b9a5-292d7b5b24dc" class="code"><code>public String evaluarPeticion(Libro libro) {
		// consulta por isbn
		if(libro.getAutor()==null &amp; libro.getTitulo()==null){
			texto = buscarLibroByCodigo(libro.getIsbn());
			return texto;
		}
		// consulta por titulo
		else if(libro.getAutor()==null &amp; libro.getIsbn()==null) {
			texto = buscarLibroByTitulo(libro.getTitulo());
			return texto;
		}
		// consulta por autor
		else if(libro.getIsbn()==null &amp; libro.getTitulo()==null) {
			texto = buscarLibroByAutor(libro.getAutor());
			return texto;	
		}
		// unica opción que queda, añadir libro
		else {
			registrarLibro(libro);
			return &quot;Libro &quot;+ libro.getTitulo() +&quot; añadido&quot;;
		}	
	}</code></pre><p id="6fad41fe-65ec-40fa-a6d5-52848b4da0d0" class="">Como recibimos de valor un <code>Libro</code>, usamos sus propiedades para evaluar que quiere el usuario y devolver los datos que solicita.</p><p id="66c0eeb7-d833-4525-a0a5-68e1e5ab8dbc" class="">Añadimos un método basado en el anterior, solo para que nos informe al servidor exclusivamente de que esta solicitando el cliente.</p><pre id="37350184-2a56-46ad-ada8-ef54a799f954" class="code"><code>public String evaluarPeticionServidor(Libro libro) {
		// consulta por isbn
		if(libro.getAutor()==null &amp; libro.getTitulo()==null){
			texto = &quot;Consulta de libro por ISBN&quot;;
			return texto;
		}
		// consulta por titulo
		else if(libro.getAutor()==null &amp; libro.getIsbn()==null) {
			texto = &quot;Consulta de libro por titulo&quot;;
			return texto;
		}
		// consulta por autor
		else if(libro.getIsbn()==null &amp; libro.getTitulo()==null) {
			texto = &quot;Consulta de libro por Autor&quot;;
			return texto;	
		}
		// unica opción que queda, añadir libro
		else {
			
			return &quot;Añadir libro&quot;;
		}	
	}</code></pre><p id="a8c24ce6-96e0-4d77-936a-2b3c4c26bd59" class="">Pasemos a la clase <code>Hilo</code> , donde cada vez que el servidor recibe una petición de entrada de cliente crea un <code>Hilo</code> y es este quien va a gestionar todas las operaciones, como os mostrara el siguiente código. </p><pre id="8c4d468a-5710-48c2-895c-b92e17433c96" class="code"><code>@Override
	public void run() {
		System.out.println(&quot;Estableciendo comunicación con &quot; + hilo.getName());
		PrintStream salida = null;
		InputStreamReader entrada = null;
		BufferedReader entradaBuffer = null;		
		Gson gson= new Gson();
		
		
		try {
			
			salida = new PrintStream(socketAlCliente.getOutputStream());
			entrada = new InputStreamReader(socketAlCliente.getInputStream());
			entradaBuffer =  new BufferedReader(entrada);
			
			String texto = &quot;&quot;;
			boolean continuar = true;
			
			while(continuar) {
				texto = entradaBuffer.readLine();
				
				if(texto.equalsIgnoreCase(&quot;FIN&quot;)) {
					salida.println(&quot;Cerrando conexión&quot;);
					System.out.println(hilo.getName() + &quot; ha cerrado la comunicacion&quot;);
					continuar = false;					
				}else{
					
					Libro libro = gson.fromJson(texto, Libro.class);
					System.out.println(&quot;El&quot; + hilo.getName()+ &quot; &quot; + biblio.evaluarPeticionServidor(libro));
					String respuesta = biblio.evaluarPeticion(libro);
					salida.println(respuesta);
					System.out.println(&quot;SERVIDOR: le ha respondido al cliente : \n&quot; + respuesta.replaceAll(&quot;@@&quot;, &quot;\n&quot;));		
				}
			}
			// Matamos el hilo
			socketAlCliente.close();
	
		} catch (IOException e) {
			System.err.println(&quot;Hilo: Error de entrada/salida&quot;);
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println(&quot;Hilo: Error&quot;);
			e.printStackTrace();
		}
		
	}</code></pre><p id="b1461704-44cf-466f-b715-262d5937b1d1" class="">Cuando recibimos la información del cliente, lo primero que comprobaremos es si el <code>texto=&quot;FIN&quot;</code></p><p id="e273caff-c385-4a0f-aa45-ad1f1ec85e91" class="">Si es así, cerraremos la conexión con el cliente mediante <code>continuar = false</code> así no se volverá a ejecutar el bucle y cerramos conexión <code>socketAlCliente.close()</code></p><p id="2161add9-30f6-46d9-be54-29357e68b870" class="">De no ser así, lo primero que haremos es pasar el JSON que nos ha enviado el cliente a un objeto <code>Libro</code> así podremos manejar los datos más fácilmente, pudiendo acceder a todos los métodos del <code>Libro </code> mediante <code>Libro libro = gson.fromJson(texto, Libro.class)</code></p><p id="55ba9ce7-0276-481d-9359-cf93475274c1" class="">Usaremos el método <code>biblio.evaluarPeticion(libro)</code> para evaluar la petición del cliente y devolverle la respuesta necesaria, que se la enviaremos <code>salida.println(respuesta)</code></p><p id="19be17f3-3aa1-46f3-a347-35adc64a8b13" class="">Como información adicional, solo para el SERVIDOR usaremos el método <code>biblio.evaluarPeticionServidor(libro)</code> para tener más información del cliente.</p><p id="1d1b8924-b395-4903-81b3-6d80696b0098" class="">Una vez obtenida la información se la enviamos al cliente <code>salida.println(respuesta)</code> y seguiremos a la escucha hasta que nos diga que cierra la conexión.</p><p id="4012294b-0a82-4d89-b4d0-2d11616bb025" class="">
</p></div></article></body></html>