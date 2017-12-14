/**
 * Асинхронно загрузить скрипт по адресу url, и вызвать opt_onLoad по завершении.
 * @param url Урл для загрузки скрипта
 * @param opt_onLoad Опциональная функция, которая будет вызвана при завершении загрузки скрипта
 */
function importScript(url, opt_onLoad) {
  var oHead = document.head || document.getElementsByTagName("head")[0];
  var oScript = document.createElement("script");
  oScript.onerror = function(oError) {
    throw new URIError("The script " + oError.target.src + " is not accessible.");
  };
  if (opt_onLoad) oScript.onload = opt_onLoad;
  oHead.appendChild(oScript);
  oScript['async'] = 1;
  oScript.src = url;
}

/**
 * Загрузка jsPart только если он не был загружен.
 * @param name Имя части, как он записан в jsParts
 * @param url Урл для подгрузки
 */
function importJsPart(name, url) {
  if (!jsParts[name]) {
    jsParts[name] = 1;
    importScript(url, function() {
      jsPartEnd(name);
    });
  }
}

/**
 * Заглушка для функции jsPartEnd. Эта функция должна быть вызвана в конце каждой части jsPart.
 */
function jsPartEnd(n) {
  jsParts[n] = 2;
}

/**
 * Добавить функцию на выполнение после загрузки всех jsParts.
 * Если все jsParts загружены, то функция будет выполнена немедленно.
 */
function jsOnLoad(exec) {
  if (!window.execs) execs = [];
  execs.push(exec);
  window.jsTryRunExecs && jsTryRunExecs();
}
