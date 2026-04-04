const AppConfig = {
  apiBase: () => window.location.origin,

  defaultNamespace:   null,
  historyExternalUrl: null,

  async load() {
    try {
      const res = await fetch(
        `${this.apiBase()}/api/config`,
        { signal: AbortSignal.timeout(3000) }
      );
      const cfg = await res.json();
      this.defaultNamespace   = cfg.defaultNamespace;
      this.historyExternalUrl = cfg.historyExternalUrl;

      // populate namespace dropdown
      const sel = document.getElementById('nsSelect');
      sel.innerHTML = '';
      cfg.namespaces.forEach(n => {
        const o = document.createElement('option');
        o.value = n; o.textContent = n;
        if (n === cfg.defaultNamespace) o.selected = true;
        sel.appendChild(o);
      });

      const frame = document.getElementById('historyFrame');
      if (frame) frame.src = '/proxy/history/';

      const extLink = document.getElementById('historyExternalLink');
      if (extLink) extLink.href = cfg.historyExternalUrl;

    } catch (_) {
      const frame = document.getElementById('historyFrame');
      if (frame) frame.src = 'about:blank';
    }
  }
};