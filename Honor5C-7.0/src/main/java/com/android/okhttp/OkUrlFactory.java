package com.android.okhttp;

import com.android.okhttp.internal.URLFilter;
import com.android.okhttp.internal.huc.HttpURLConnectionImpl;
import com.android.okhttp.internal.huc.HttpsURLConnectionImpl;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

public final class OkUrlFactory implements URLStreamHandlerFactory, Cloneable {
    private final OkHttpClient client;
    private URLFilter urlFilter;

    /* renamed from: com.android.okhttp.OkUrlFactory.1 */
    class AnonymousClass1 extends URLStreamHandler {
        final /* synthetic */ String val$protocol;

        AnonymousClass1(String val$protocol) {
            this.val$protocol = val$protocol;
        }

        protected URLConnection openConnection(URL url) {
            return OkUrlFactory.this.open(url);
        }

        protected URLConnection openConnection(URL url, Proxy proxy) {
            return OkUrlFactory.this.open(url, proxy);
        }

        protected int getDefaultPort() {
            if (this.val$protocol.equals("http")) {
                return 80;
            }
            if (this.val$protocol.equals("https")) {
                return 443;
            }
            throw new AssertionError();
        }
    }

    public OkUrlFactory(OkHttpClient client) {
        this.client = client;
    }

    public OkHttpClient client() {
        return this.client;
    }

    void setUrlFilter(URLFilter filter) {
        this.urlFilter = filter;
    }

    public OkUrlFactory clone() {
        return new OkUrlFactory(this.client.clone());
    }

    public HttpURLConnection open(URL url) {
        return open(url, this.client.getProxy());
    }

    HttpURLConnection open(URL url, Proxy proxy) {
        String protocol = url.getProtocol();
        OkHttpClient copy = this.client.copyWithDefaults();
        copy.setProxy(proxy);
        if (protocol.equals("http")) {
            return new HttpURLConnectionImpl(url, copy, this.urlFilter);
        }
        if (protocol.equals("https")) {
            return new HttpsURLConnectionImpl(url, copy, this.urlFilter);
        }
        throw new IllegalArgumentException("Unexpected protocol: " + protocol);
    }

    public URLStreamHandler createURLStreamHandler(String protocol) {
        if (protocol.equals("http") || protocol.equals("https")) {
            return new AnonymousClass1(protocol);
        }
        return null;
    }
}
