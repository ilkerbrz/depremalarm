package com.labawsrh.aws.introscreen;


import android.content.Intent;
import android.graphics.Color;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.Locale;

public class HayatUcgeni extends AppCompatActivity {
    private TextSwitcher textSwitcher;
    private ImageButton nextButton;
    private ImageButton backButton;
    private TextView yazilar;
    private TextToSpeech mTTS;
    private ImageButton speakses;
    private int stringIndex = 0;
    private String[] row = {"Adım Doug Copp. Dünyanın en tecrübeli kurtarma birimi Amerikan Uluslararası Kurtarma Ekibinin Kurtarma şefi ve afet olayları müdürüyüm. Bu makaledeki bilgiler bir deprem anında hayat kurtaracaktır.", "İçinde 20 maket olan bir okulu ve evi yıktık. On maket “çömel ve korun” metodunu uygularken, 10 maket “hayat üçgeni” metodumu uyguladı.\n\n" +
            "Tasarlanmış yıkımdan sonra görüntüleri filme almak ve sonuçları belgelemek için enkazı geçip binaya girdik. Bina yıkımlarında oluşabilecek şartlar dahilinde direk olarak gözlemlenebilen ve bilimsel şartlar altında hayatta kalma tekniklerimi uyguladığım film “çömelip korunan/saklanan” kişiler için hayatta kalma şansının sıfır olduğunu ortaya koydu. Hayat üçgeni metodumu kullananlar için hayatta kalabilme şansı yaklaşık olarak % 100 oldu. Bu film Türkiye de ve Avrupanın geri kalan kısmında milyonlarca izleyici tarafından izlendi.", "Her bir çocuk kemiklerinin kalınlığına kadar ezilmişlerdi. Sıralarının yanındaki koridorlara uzanmış olsalardı hayatta kalmış olabilirlerdi. Bu “ayıptı, gereksizdi” ve çocukların neden koridorlarda (sıraların arasında) olmadığını merak ettim. O an, çocuklara bir şeyin/eşyanın altına saklanmalarının söylendiğini bilmiyordum.” \n" +
            "\nBasitçe ifade edilirse, binalar yıkılırken, objelerin üzerine düşen tavan ağırlığı veya içerideki mobilyalar bu nesnelere çarparken yanlarında bir yer, boşluk bırakırlar. Bu boşluk benim “hayat üçgeni” dediğim alandır. Nesne ne kadar büyük ve ne kadar dayanıklı olursa daha az ezilecektir. Nesneler ne kadar az ezilirse boşluk ve bu boşluğu kullanan kişinin yaralanmama olasılığı o kadar artar. Bir dahaki sefere televizyonda yıkılan bina izlerken gördüğün üçgenleri say. Her yerdeler. Yıkılan bir binada göreceğiniz en yaygın biçimdir.", "1. “Binalar Çökerken Basitçe “Çömelen Ve Korunan” Kişiler İstisnasız Her Defasında Ezilerek Ölüyorlar.\n" +
            "\nMasa, Araba Gibi Nesnelerin Altına Giren Kişiler Her Zaman Ezilirler.\n\n 2. Mutlaka Cenin Pozisyonu Alın.\n\n" +
            "Kediler, köpekler ve bebeklerin hepsi doğal bir şekilde dizlerini ana rahmindeki gibi karınlarına doğru çekerek kıvrılırlar. Deprem anında siz de bu şekilde kıvrılmalısınız. Bu doğal bir güvenlik ve hayatta kalma içgüdüsüdür. Daha küçük bir boşlukta hayatta kalabilirsiniz. Hafifçe ezilecek ama yanında boşluk oluşturacak bir kanepenin, geniş büyük bir eşyanın yanında dur.", "3. Gece Depreme Yakalanırsanız Yataktan Yavaşça Düşün.\n\n" +
            "Eğer gece yataktayken deprem olursa, basitçe yuvarlanarak yataktan düşün. Yatağın çevresinde güvenli bir boşluk oluşacaktır. Oteller müşterilerine deprem anında yatakların yanında yere uzanmalarını salık veren bir uyarı notunu odalarda her kapının arkasına asarlarsa depremlerde çok büyük hayatta kalma oranlarını sağlayabilirler.", "4. Salonda Yakalanırsanız Koltuğunuza Sığının.\n\n" +
            "Televizyon izlerken deprem olursa ve kolayca kapıdan veya pencereden dışarı kaçmak mümkün değilse, kanepe veya büyük bir koltuğun/sandalyenin yanında cenin pozisyonunda kıvrılarak yere uzanın..\n\n 5. Kapı Kirişlerinden Uzak Durun.\n\n" +
            "Bina çökerken kapı kirişlerinin altına geçen herkes ölür…Nasıl mı? Eğer kapı kirişlerinin altına geçerseniz ve kapı kirişi öne veya arkaya doğru düşürse inen tavanın altında ezilirsiniz. Eğer kapı kirişi yana doğru yıkılırsa ikiye bölünürsünüz. Her iki durumda da ölürsünüz! ", "6. Merdivenlerden Uzak Durun.\n\n" +
            "Hiçbir zaman merdivenlere gitmeyin/yönelmeyin. Merdivenler (ana binadan) farklı bir “frekans aralığına” sahiptir; ana binadan bağımsız/ayrı olarak sarsılırlar. Merdivenler ve binanın geri kalanı devamlı olarak birbirlerine çarparlar, ta ki merdivenlerin yıkılışı gerçekleşene kadar. Merdivenlere ulaşan insanlar basamaklar yüzünden yaralanırlar. Korkunç şekilde sakatlanırlar. Bina yıkılmasa dahi, merdivenlerden uzak durun. Merdivenler binanın hasar görmesi en muhtemel kısmıdır. Depremde yıkılmamış olsa dahi, merdivenler bağırarak kaçmaya çalışan insanların aşırı yüklenmesi ile çökebilir. Merdivenler binanın geri kalan kısmı zarar görmemiş olsa dahi her zaman güvenlik açısından kontrolden geçirilmelidir.", "7. Binanın Dış Duvarlarının Yakınında Olun.\n\n" +
            "Binanın dış duvarlarına yakın yerlerde durun, mümkünse dışına çıkın. Binanın iç kısımlarındansa dış kısımlarına yakın yerlerde olmak çok daha iyidir. Binanın dış çevresinden ne kadar içeride olursanız, çıkış yolunuzun kapanma ihtimali o kadar artacaktır. \n\n8. Bulunduğunuz Yerde Büyük Kağıt Yığınları Varsa Şanslısınız.\n\n" +
            "Enkaz halindeki gazete ofislerini ve çok miktarda kağıdın olduğu ofisleri dolaşırken kağıdın sıkışmadığını/ezilmediğini keşfettim. Kağıt yığınlarının/kümelerinin etrafında geniş boşluklar bulunur/oluşur.", "9. Araçta İseniz Aracınızdan Çıkıp Yanına Kıvrılın.\n\n" +
            "Aynen Nimitz yolundaki katlar arasındaki (yıkılan) blokların meydana getirdiği gibi, deprem anında üst yolun yıkılmasıyla ezilen araçların içinde bulunan insanlar ezilirler. San Francisco depreminin kurbanlarının hepsi araçlarının içindeydiler. Hepsi öldü. Araçlarının dışına çıkıp, aracın yanına uzanıp veya oturarak kolaylıkla hayatta kalabilirlerdi. Ölen herkes eğer araçlarından çıkıp, araçlarının yanına oturabilseler veya uzanabilselerdi yaşıyor olabilirdi. Ezilen bütün araçların yanında-kolonların direkt olarak üzerine düştüğü araçlar hariç- 3 feet yükseklikte boşluklar oluşmuştu.", "Hayat Üçgeni eğitimimiz bu kadardı. Unutmadan olası bir deprem anında\n\nHER ZAMAN HATIRLAYIN!"};
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hayat_ucgeni);

        speakses = findViewById(R.id.alarmbuton2);
        yazilar = findViewById(R.id.textView9);

        textSwitcher = findViewById(R.id.textSwitcher);
        nextButton = findViewById(R.id.alarmbuton3);
        backButton = findViewById(R.id.alarmbuton5);

        yazilar.setText("Adım Doug Copp. Dünyanın en tecrübeli kurtarma birimi Amerikan Uluslararası Kurtarma Ekibinin Kurtarma şefi ve afet olayları müdürüyüm. Bu makaledeki bilgiler bir deprem anında hayat kurtaracaktır.");
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stringIndex == row.length - 1) {
                    stringIndex = 0;


                    backButton.setVisibility(v.INVISIBLE);

                    textSwitcher.setText(row[stringIndex]);
                    yazilar.setText(row[stringIndex]);
                } else {
                    textSwitcher.setText(row[++stringIndex]);
                    yazilar.setText(row[stringIndex]);
                    backButton.setVisibility(v.VISIBLE);
                }
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stringIndex == row.length - 1) {
                    stringIndex = 0;
                    backButton.setVisibility(v.INVISIBLE);
                    yazilar.setText(row[stringIndex]);
                    textSwitcher.setText(row[stringIndex]);
                } else {

                    if (stringIndex == 1){
                        backButton.setVisibility(v.INVISIBLE);
                        textSwitcher.setText(row[--stringIndex]);
                        yazilar.setText(row[stringIndex]);
                    }
                    else {
                        textSwitcher.setText(row[--stringIndex]);
                        yazilar.setText(row[stringIndex]);
                    }


                }
            }
        });

        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                textView = new TextView(HayatUcgeni.this);
                textView.setGravity(Gravity.CENTER_HORIZONTAL);
                return textView;
            }
        });

        textSwitcher.setText(row[stringIndex]);



        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS){
                    int result = mTTS.setLanguage(new Locale("tr-TR"));

                    if(result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Malesef bu dili destekleyemiyoruz");
                    }
                } else {
                    Log.e("TTS", "Doğrulama başarısız");
                }

            }

        });

        speakses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });




    }
    private void speak(){
        String text = yazilar.getText().toString();
        mTTS.setSpeechRate(1f);

        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);

    }

    @Override
    protected void onDestroy() {

        if (mTTS != null){
            mTTS.stop();
            mTTS.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {

        Intent gecis = new Intent(HayatUcgeni.this,MainActivity.class);
        startActivity(gecis);
        finish();
        super.onBackPressed();
    }
}