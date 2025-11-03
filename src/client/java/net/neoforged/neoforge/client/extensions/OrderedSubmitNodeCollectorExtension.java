package net.neoforged.neoforge.client.extensions;

import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.OrderedSubmitNodeCollector;

public interface OrderedSubmitNodeCollectorExtension {

    /**
     * Similar to a {@link OrderedSubmitNodeCollector#submitCustomGeometry} however, with
     * access to create custom {@link RenderPass RenderPasses} as required.
     *
     * @param poseStack The pose stack to capture.
     * @param renderer  The renderer to use.
     */
    void submitCustomRenderPass(PoseStack poseStack, CustomRenderPassRenderer renderer);

    interface CustomRenderPassRenderer {

        /**
         * Called to render your custom {@link RenderPass RenderPasses}.
         *
         * @param pose    The pose captured from submission time.
         * @param buffers The {@link MultiBufferSource.BufferSource} for immediate rendering and ordering.
         */
        void render(PoseStack.Pose pose, MultiBufferSource.BufferSource buffers);
    }
}
