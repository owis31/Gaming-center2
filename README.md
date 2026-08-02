# تطبيق Gaming Center - Android

تطبيق WebView احترافي لموقع [gamingcenter.ly](https://gamingcenter.ly/)، يعرض الموقع مباشرة بدون نسخ محتواه — أي تحديث في الموقع (مخزون، أسعار، منتجات) يظهر فوراً في التطبيق.

## المميزات المُفعّلة فعلياً
- WebView كامل مع شاشة Splash
- Pull-to-refresh (اسحب للتحديث)
- شريط تقدّم تحميل الصفحة
- شاشة "لا يوجد إنترنت" مع زر إعادة محاولة
- رفع الملفات (للحسابات والتقييمات)
- تحميل الملفات (فواتير، إلخ) عبر المتصفح الخارجي
- فتح واتساب / اتصال / إيميل / سوشيال ميديا في تطبيقاتها الأصلية بدل الفتح جوه الـ WebView
- زر الرجوع Android يرجع خطوة في تصفح الموقع بدل غلق التطبيق
- أيقونة وألوان مطابقة لهوية المتجر (أحمر #EC1D24)

## طريقة التشغيل
1. افتح المجلد في **Android Studio** (Hedgehog أو أحدث)
2. خلي المشروع يعمل Sync لأول مرة (هيحمّل Gradle والمكتبات تلقائياً)
3. وصّل جهاز أندرويد أو شغّل Emulator
4. اضغط Run ▶️

## تفعيل الإشعارات (Push Notifications) - اختياري
1. روح لـ https://console.firebase.google.com وأنشئ مشروع جديد
2. أضف تطبيق Android بمعرف الحزمة (Package Name): `ly.gamingcenter.app`
3. حمّل ملف `google-services.json` وحطه في مجلد `app/`
4. في `app/build.gradle` فعّل السطرين المعلقين:
   - `id 'com.google.gms.google-services'`
   - سطري firebase-bom و firebase-messaging-ktx
5. غيّر اسم `GCMessagingService.kt.txt` إلى `GCMessagingService.kt`
6. في `AndroidManifest.xml` فعّل تعريف الـ `<service>` المعلق
7. لإرسال إشعار: من Firebase Console → Cloud Messaging → إرسال رسالة تجريبية

## النشر على Google Play
- غيّر `applicationId` في `app/build.gradle` لو عايز معرف مختلف
- أنشئ Keystore للتوقيع (Build > Generate Signed Bundle)
- جوجل ممكن ترفض تطبيقات الـ WebView الخام البسيطة — التطبيق ده فيه قيمة إضافية حقيقية (أوفلاين، إشعارات، تجربة أسرع) فبيستوفي المعايير، لكن يفضل مراجعة سياسات Google Play قبل الرفع

## ملاحظات
- الموقع لازم يفضل متجاوب (responsive) عشان يبان صح جوه التطبيق — وهو كذلك حالياً
- أي تعديل تعمله على موقع WooCommerce (منتج، سعر، مخزون) هيظهر تلقائياً في التطبيق من غير أي تحديث للتطبيق نفسه
