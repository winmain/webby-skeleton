// Методы для работы с куками
function getCookie(name) {
  var result = new RegExp("(?:^|; )" + name + "=([^;]*)").exec(document.cookie);
  return result && result[1];
}

function setCookie(name, value, expireSeconds) {
  var expires = new Date(expireSeconds <= 0 ? 0 : new Date().getTime() + expireSeconds * 1000);
  document.cookie = name + '=' + value + ';path=/;expires=' + expires;
}

function removeCookie(name) {
  setCookie(name, '', 0);
}

// Создание html как в jquery
function htmlToEl(html) {
  var template = document.createElement('template');
  template.innerHTML = html;
  return template.content.firstChild;
}

document.addEventListener("DOMContentLoaded", function() {
  /**
   * Добавить переключалку админской печеньки _adm_js_closure ("[x] gcc" в правом верхнем углу)
   */
  var jsClosure = getCookie("_adm_js_closure");

  var jsClosureDiv = htmlToEl('<div id="adm-js-closure" style="position:absolute; z-index:99999; top:5px; right:80px; cursor:pointer; background:rgba(0,0,0,0.1); font:10px monospace; color:' + (jsClosure ? '#fff' : '#888') + ')">');
  jsClosureDiv.innerHTML = (jsClosure ? "[x]" : "[ ]") + " gcc";
  jsClosureDiv.onclick = function() {
    document.cookie = "_adm_js_closure=1;path=/;" + (jsClosure ? "expires=Thu, 01 Jan 1970 00:00:01 GMT" : "");
    window.location.reload();
  };
  document.querySelector('body').appendChild(jsClosureDiv);


  /**
   * Инициализировать web-runner-client
   */
  if (window['EventSource']) {
    // Set this port value to the `wrWebServerPort` setting from `build.sbt`
    var evtSource = new EventSource("http://127.0.0.1:4822/");

    var autoReloadCookie = '_autoreload';
    var cookieMaxAgeSeconds = 365 * 3600 * 24;
    var updateReqHandlerCookie = '_update-request-handler'; // Эта кука выставляется для того, чтобы пересоздать Global.requestHandler

    var autoReload = getCookie(autoReloadCookie) == '1';

    if (getCookie(updateReqHandlerCookie)) removeCookie(updateReqHandlerCookie);
    var state = "...";

    var baloon = htmlToEl('<div id="web-runner-baloon" style="position:absolute; top:0; right:0; font: 11px Verdana, sans-serif; padding: 3px 5px;">...</div>');
    document.querySelector('body').appendChild(baloon);

    var updateBaloon = function() {
      var stateText = state == 'running' ? 'run' : state;
      baloon.innerHTML = stateText + " <span class='ar" + (autoReload ? 1 : 0) + "'>↻</span>";
      baloon.className = state;
      jsClosureDiv.style.display = state == 'off' ? 'none' : 'inherit';
    };

    var toggleAutoReload = function() {
      autoReload ^= 1;
      setCookie(autoReloadCookie, autoReload ? 1 : 0, cookieMaxAgeSeconds);
      updateBaloon();
    };

    evtSource.onmessage = function(e) {
      var newState = JSON.parse(e.data)['state'];
      if (autoReload) {
        var afterCompile = (state == 'compiling' || state == 'compile-error') && newState == 'running';
        var assetChanged = state == 'running' && newState == 'asset-changed';
        if (afterCompile) {
          // Ожидание перед перезагрузкой нужно, чтоб jrebel6 смог перезагрузить класс, иначе откроется старая версия сайта
          newState = 'waiting for jrebel6';
          setCookie(updateReqHandlerCookie, '1', cookieMaxAgeSeconds);
          window.location.reload();
        } else if (assetChanged) {
          window.location.reload();
        }
      }
      state = newState;
      updateBaloon();
    };
    evtSource.onerror = function() {
      state = 'off';
      updateBaloon();
    };

    baloon.onclick = toggleAutoReload;
  }
}, false);
